/*
 * MyTake.org website and tooling.
 * Copyright (C) 2020 MyTake.org, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Additional permission under GNU GPL version 3 section 7
 *
 * If you modify this Program, or any covered work, by linking or combining it
 * with Eclipse SWT (or a modified version of that library), containing parts
 * covered by the terms of the Eclipse Public License, the licensors of this Program
 * grant you additional permission to convey the resulting work.
 * {Corresponding Source for a non-source form of such a combination shall include the
 * source code for the parts of Eclipse SWT used as well as that of the covered work.}
 *
 * You can contact us at team@mytake.org
 */
package org.mytake.factset.gradle;


import com.diffplug.common.base.Unhandled;
import com.diffplug.common.collect.Iterables;
import com.diffplug.gradle.spotless.FormatExtension;
import com.diffplug.gradle.spotless.SpotlessExtension;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java2ts.FT;
import org.eclipse.jgit.util.sha1.SHA1;
import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.file.FileCollection;
import org.gradle.api.file.FileTree;
import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.gradle.api.tasks.TaskAction;
import org.gradle.work.FileChange;
import org.gradle.work.Incremental;
import org.gradle.work.InputChanges;
import org.mytake.factset.GitJson;
import org.mytake.factset.JsonMisc;
import org.mytake.factset.video.Ingredients;

public class MtdoFactset {
	private final SpotlessExtension spotlessExt;

	static final String SAID = "said";
	static final String VTT = "vtt";

	public MtdoFactset(SpotlessExtension spotlessExt) throws IOException {
		this.spotlessExt = spotlessExt;
	}

	public String title;
	public String id;
	public Action<FT.VideoFactMeta> videoJson = unused -> {};

	public void videoJson(Action<FT.VideoFactMeta> videoJson) {
		this.videoJson = videoJson;
	}

	public void videoTranscript(Action<FormatExtension> saidAndVtt) {
		spotlessExt.format(SAID, saidAndVtt);
		spotlessExt.format(VTT, saidAndVtt);
	}

	@CacheableTask
	public static class GrindTask extends DefaultTask {
		/** Configures the grinding (ignored for up-to-date). */
		MtdoFactset setup;
		/** Used as an up-to-date proxy for setup. */
		File buildDotGradle;
		FileTree ingredients;
		File sausageDir;

		@Internal
		public MtdoFactset getSetup() {
			return setup;
		}

		@PathSensitive(PathSensitivity.NAME_ONLY)
		@InputFile
		public File getBuildDotGradle() {
			return buildDotGradle;
		}

		@PathSensitive(PathSensitivity.RELATIVE)
		@Incremental
		@InputFiles
		public FileCollection getIngredients() {
			return ingredients;
		}

		@OutputDirectory
		public File getSausageDir() {
			return sausageDir;
		}

		@TaskAction
		public void performAction(InputChanges inputs) throws Exception {
			if (setup.id == null) {
				throw new IllegalArgumentException("id must not be null, recommend https://github.com/mytakedotorg/<id>");
			}
			if (setup.title == null) {
				throw new IllegalArgumentException("title must not be null, recommend something like 'U.S. Presidential Debates'");
			}

			// wipe the sausage dir on non-incremental builds
			if (!inputs.isIncremental()) {
				getLogger().info("Not incremental: removing prior outputs");
				Files.walk(sausageDir.toPath())
						.sorted(Comparator.reverseOrder())
						.map(Path::toFile)
						.forEach(File::delete);
				Files.createDirectories(sausageDir.toPath());
			}

			// find all changed and removed files
			Set<String> changed = new TreeSet<>();
			Set<String> removed = new TreeSet<>();
			Iterable<FileChange> changes = inputs.getFileChanges(ingredients);
			for (FileChange change : changes) {
				switch (change.getChangeType()) {
				case MODIFIED:
				case ADDED:
					changed.add(Ingredients.withoutExtension(change.getNormalizedPath()));
					break;
				case REMOVED:
					removed.add(Ingredients.withoutExtension(change.getNormalizedPath()));
					break;
				default:
					throw Unhandled.enumException(change.getChangeType());
				}
			}

			// for every removed/changed file, delete it from sausage
			Map<String, String> buildJson = readBuildDotJson();
			for (String path : Iterables.concat(removed, changed)) {
				String dest = buildJson.remove(path);
				if (dest != null) {
					getLogger().info("cleaning: " + path + " -> " + dest);
					Files.deleteIfExists(sausageDir.toPath().resolve(dest + ".json"));
				} else {
					getLogger().info("cleaning: " + path + " (already clean)");
				}
			}

			// configure the grinding logic
			GrindLogic grind = new GrindLogic(sausageDir.getParentFile().toPath(), setup, getLogger());
			// grind each changed file
			grind.grind(changed, buildJson);
			GitJson.write(buildJson).toPretty(new File(sausageDir, "build.json"));
			// write out the index
			FT.FactsetIndex index = new FT.FactsetIndex();
			index.title = setup.title;
			index.id = setup.id;

			grind.buildIndex(index, sausageDir.toPath());
			GitJson.write(index).toCompact(new File(sausageDir, "index.json"));
			// generate any warnings
			GrindLogic.Validator validator = grind.validator();
			for (Map.Entry<String, String> entry : buildJson.entrySet()) {
				for (String warning : validator.warningsFor(entry.getKey())) {
					getLogger().warn(GrindLogic.INGREDIENTS + "/" + entry.getKey() + ".json: " + warning);
				}
			}
			String allFound = validator.allFound();
			if (!allFound.isEmpty()) {
				getLogger().warn(allFound);
			}
		}

		private Map<String, String> readBuildDotJson() throws IOException {
			File buildJson = new File(sausageDir, "build.json");
			if (!buildJson.exists()) {
				Files.createDirectories(sausageDir.toPath());
				return new TreeMap<>();
			}
			return new TreeMap<>(JsonMisc.fromJson(buildJson, MAP_STRING));
		}

		private static final TypeToken<Map<String, String>> MAP_STRING = new TypeToken<Map<String, String>>() {};
	}

	/**
	 * Takes the SHA1 hash of the 'id' field of the factset,
	 * then truncates to only the first 5 bytes, then calls
	 * `Base64.getUrlEncoder().encodeToString` which returns
	 * something that looks like `E74aoUY=` (always ends in an equals).
	 */
	static String factsetIdHash(FT.FactsetIndex index) {
		SHA1 sha = SHA1.newInstance();
		sha.update(index.id.getBytes(StandardCharsets.UTF_8));
		byte[] bytes = sha.digest();
		// base64 encodes 3 bytes into 4 ascii characters
		// and if you have 2 bytes leftover, then it pads an `=`
		// so with 5 bytes, you have 40 bits, and 1e12 is plenty,
		// and `=` is a nice human-friendly separator
		int numBlocks = 1;
		byte[] trimmed = Arrays.copyOf(bytes, numBlocks * 3 + 2);
		return Base64.getUrlEncoder().encodeToString(trimmed);
	}
}
