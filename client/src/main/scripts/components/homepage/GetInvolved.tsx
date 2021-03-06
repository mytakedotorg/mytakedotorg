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
 * You can contact us at team@mytake.org
 */
import React from "react";
import HomeSection from "./HomeSection";

const GetInvolved: React.FC = () => {
  return (
    <HomeSection>
      <h2 className="home__h2">Get involved</h2>
      <div className="home__link-container">
        <a
          className="home__link"
          href="https://meta.mytake.org/t/using-mytake-org-to-teach-about-the-environment/157"
        >
          Forum for teachers
        </a>
        <a
          className="home__link"
          href="https://github.com/mytakedotorg/mtdo/blob/staging/DEV_QUICKSTART.md"
        >
          GitHub repo for developers
        </a>
        <a
          className="home__link"
          href="https://meta.mytake.org/t/seeking-help-transcribing-debates/160"
        >
          Help us add more facts
        </a>
        <a
          className="home__link"
          href="https://docs.google.com/spreadsheets/d/1SZtK9ajcQAs8la1dqnHtc9yAWJK7j-26HBrAx-gtUDY/edit#gid=1674413579"
        >
          Donate money to keep it running
        </a>
      </div>
    </HomeSection>
  );
};

export default GetInvolved;
