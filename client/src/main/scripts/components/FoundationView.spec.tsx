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
import * as renderer from "react-test-renderer";
import FoundationView from "./FoundationView";

jest.mock("./timeline/TimelineView", () => ({
  __esModule: true,
  default: "TimelineView",
}));

test("With fact in URL", () => {
  const path = "/foundation/bill-of-rights";
  const tree = renderer.create(<FoundationView path={path} />).toJSON();
  expect(tree).toMatchSnapshot();
});

test("Without fact in URL", () => {
  const path = "/foundation";
  const hashURL = "";
  const tree = renderer.create(<FoundationView path={path} />).toJSON();
  expect(tree).toMatchSnapshot();
});
