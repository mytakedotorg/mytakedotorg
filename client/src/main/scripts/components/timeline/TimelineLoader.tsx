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
import React, { useEffect, useState } from "react";
import { decodeSocial, PreviewSocial } from "../../common/social/social";
import { FT } from "../../java2ts/FT";
import { Routes } from "../../java2ts/Routes";
import TimelineLoadingView from "./TimelineLoadingView";
import { SetFactHandlers } from "./TimelinePreview";
import TimelineView from "./TimelineView";
import { get } from "../../network";
import { FACTSET_BY_HASH } from "../../common/factsets";

interface TimelineLoaderProps {
  path: string;
  setFactHandlers?: SetFactHandlers;
}

interface TimelineLoaderState {
  factsetHash: string;
  facts?: FT.FactLink[];
}

const TimelineLoader: React.FC<TimelineLoaderProps> = (props) => {
  const [state, setState] = useState<TimelineLoaderState>({
    factsetHash: Object.keys(FACTSET_BY_HASH)[0], // start with the first factset
  });

  useEffect(() => {
    async function getAllFacts() {
      const index: FT.FactsetIndex = await get(
        `https://mytake.org${Routes.API_FACT}/${state.factsetHash}=${
          FACTSET_BY_HASH[state.factsetHash].indexBlobSha
        }.json`
      );
      setState({
        factsetHash: state.factsetHash,
        facts: index.facts,
      });
    }
    getAllFacts();
  }, []);

  const parseURL = (path: string): PreviewSocial | null => {
    const embedSlash = path.lastIndexOf("/");
    if (embedSlash <= Routes.FOUNDATION.length) {
      return null;
    }
    const embedRison = path.substring(embedSlash + 1);
    try {
      return decodeSocial(embedRison) as PreviewSocial;
    } catch (err) {
      console.log(err);
      return null;
    }
  };

  return state.facts ? (
    <TimelineView
      initialFact={parseURL(props.path)}
      factLinks={state.facts}
      setFactHandlers={props.setFactHandlers}
    />
  ) : (
    <TimelineLoadingView />
  );
};

export default TimelineLoader;
