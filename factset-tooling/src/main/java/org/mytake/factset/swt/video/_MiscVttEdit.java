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
package org.mytake.factset.swt.video;


import com.diffplug.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import org.mytake.factset.video.VttTranscript;
import org.mytake.factset.video.VttTranscript.Mode;
import org.mytake.factset.video.Word;

/** One-off tool to edit the timestamps of a video because of tape glitch. */
public class _MiscVttEdit {
	public static void main(String[] args) throws IOException {
		VttTranscript transcript = VttTranscript.parse(new File("../presidential-debates/2000-10-17.backup"), Mode.STRICT);
		List<Word.Vtt> newWords = transcript.words().stream()
				.map(vtt -> vtt.time() < 3498.389 ? vtt : new Word.Vtt(vtt.lowercase(), vtt.time() + 10))
				.collect(Collectors.toList());
		transcript.save(newWords, Files.asCharSink(new File("../presidential-debates/2000-10-17.vtt"), StandardCharsets.UTF_8));
	}
}
