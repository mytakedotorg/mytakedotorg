/*
 * MyTake.org website and tooling.
 * Copyright (C) 2017-2020 MyTake.org, Inc.
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
import * as React from "react";
import * as ReactDOM from "react-dom";
import { windowUtils } from "./browser";
import { TakeDocument } from "./components/BlockEditor";
import BlockReader from "./components/BlockReader";
import BlockWriter, {
  InitialBlockWriterState,
  initialState,
} from "./components/BlockWriter";
import { Card } from "./components/FeedList";
import FoundationView from "./components/FoundationView";
import Home from "./components/Home";
import VideoResultsLoader from "./components/search/VideoResultsLoader";
import SearchBar from "./components/SearchBar";
import UserNav from "./components/UserNav";

windowUtils.init();

interface HomeArgs {
  type: "home";
  cards: Card[];
}

interface ShowTakeArgs {
  type: "showtake";
  takeDocument: TakeDocument;
  takeId: number;
}

interface FoundationArgs {
  type: "foundation";
}

interface NewTakeArgs {
  type: "new-take";
  blockWriterState?: InitialBlockWriterState;
}

interface SearchArgs {
  type: "search";
  searchTerm: string;
}

type MtdoArgs =
  | HomeArgs
  | ShowTakeArgs
  | FoundationArgs
  | NewTakeArgs
  | SearchArgs;

declare global {
  interface Window {
    mytake?: MtdoArgs;
  }
}

function reactElementForPage(args: MtdoArgs): React.SFCElement<any> {
  switch (args.type) {
    case "foundation":
      return (
        <FoundationView
          path={window.location.pathname}
          search={window.location.search}
        />
      );
    case "new-take":
      let initJson: InitialBlockWriterState;
      if (args.blockWriterState) {
        initJson = args.blockWriterState;
        if (!initJson.takeDocument.blocks) {
          initJson = {
            ...initJson,
            takeDocument: {
              ...initJson.takeDocument,
              blocks: [...initialState.takeDocument.blocks],
            },
          };
        }
      } else {
        initJson = (Object as any).assign({}, initialState);
      }
      return (
        <BlockWriter initState={initJson} hashUrl={window.location.hash} />
      );
    case "home":
      return <Home />;
    case "showtake":
      return <BlockReader initState={args.takeDocument} takeId={args.takeId} />;
    case "search":
      return <VideoResultsLoader searchQuery={args.searchTerm} />;
  }
}

const app = document.getElementById("app");
if (app) {
  if (window.mytake) {
    ReactDOM.render(reactElementForPage(window.mytake), app);
  } else {
    throw "window.mytake is undefined";
  }
}

if (isSearchPage(window.mytake)) {
  const searchBarContainer = document.getElementById("searchbar")!;
  ReactDOM.render(
    <SearchBar
      initialSearchQuery={window.mytake.searchTerm}
      classModifier="search"
    />,
    searchBarContainer
  );
}

const userNavContainer = document.getElementById("usernav");
if (userNavContainer) {
  ReactDOM.render(<UserNav />, userNavContainer);
} else {
  throw "Couldn't find div#usernav";
}

function isSearchPage(page?: MtdoArgs): page is SearchArgs {
  return (page as SearchArgs)?.type === "search";
}
