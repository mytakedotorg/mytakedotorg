/*
 * MyTake.org website and tooling.
 * Copyright (C) 2018-2020 MyTake.org, Inc.
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
 * You can contact us at team@mytake.org
 */
var base64toArrayBuffer = require("base64-arraybuffer");
import { bsRoundEarly } from "./functions";
import { FT } from "../java2ts/FT";

export function decodeVideoFact(
  encoded: FT.VideoFactContentEncoded
): FT.VideoFactContent {
  const data: ArrayBuffer = base64toArrayBuffer.decode(encoded.data);
  // TODO: data is little-endian.  If the user's browser is big-endian,
  // the decoding will be invalid.  Someday we should detect if the
  // browser is big-endian, and do an endian-swap if it is.  No point
  // doing this until/if we actually have a big-endian device to test
  // with.

  var offset = 0;
  const wordChar = new Int32Array(data, offset, encoded.totalWords);
  offset += encoded.totalWords * Int32Array.BYTES_PER_ELEMENT;
  const wordTime = new Float32Array(data, offset, encoded.totalWords);
  offset += encoded.totalWords * Float32Array.BYTES_PER_ELEMENT;
  const turnSpeaker = new Int32Array(data, offset, encoded.totalTurns);
  offset += encoded.totalTurns * Int32Array.BYTES_PER_ELEMENT;
  const turnWord = new Int32Array(data, offset, encoded.totalTurns);
  offset += encoded.totalTurns * Int32Array.BYTES_PER_ELEMENT;
  if (offset != data.byteLength) {
    throw Error("Sizes don't match");
  }
  return {
    fact: encoded.fact,
    durationSeconds: encoded.durationSeconds,
    youtubeId: encoded.youtubeId,
    speakers: encoded.speakers,
    plainText: encoded.plainText,
    wordChar: wordChar,
    wordTime: wordTime,
    turnSpeaker: turnSpeaker,
    turnWord: turnWord,
  };
}

export function getTurnContent(
  turn: number,
  videoFact: FT.VideoFactContent
): string {
  const firstWord = videoFact.turnWord[turn];
  const firstChar = videoFact.wordChar[firstWord];

  if (videoFact.turnWord[turn + 1]) {
    const lastWord = videoFact.turnWord[turn + 1];
    const lastChar = videoFact.wordChar[lastWord] - 1;
    return videoFact.plainText.substring(firstChar, lastChar);
  } else {
    // Result is in last turn
    return videoFact.plainText.substring(firstChar);
  }
}

export function convertSecondsToTimestamp(totalSeconds: number): string {
  let truncated = Math.round(totalSeconds);

  const hours = Math.floor(truncated / 3600);
  truncated %= 3600;
  const minutes = Math.floor(truncated / 60);
  const SS = zeroPad(truncated % 60);

  if (hours > 0) {
    return hours.toString() + ":" + zeroPad(minutes) + ":" + SS;
  } else {
    return minutes.toString() + ":" + SS;
  }
}

function zeroPad(someNumber: number): string {
  if (someNumber == 0) {
    return "00";
  } else {
    return someNumber < 10
      ? "0" + someNumber.toString()
      : someNumber.toString();
  }
}

/**
 * Assumes that both timestamps come from the same speaker.
 * Bad assumption in general, but okay for now.
 */
export function getCut(
  fact: FT.VideoFactContent,
  cut: [number, number]
): [FT.Speaker, string] {
  const wordStart = bsRoundEarly(fact.wordTime, cut[0]);
  let wordEnd = bsRoundEarly(fact.wordTime, cut[1]) + 1;
  if (fact.wordTime[wordEnd]) {
    --wordEnd;
  }
  const text = fact.plainText.slice(
    fact.wordChar[wordStart],
    fact.wordChar[wordEnd] - 1
  );
  const turn = bsRoundEarly(fact.turnWord, wordStart);
  const speaker = fact.speakers[fact.turnSpeaker[turn]];
  return [speaker, text];
}
