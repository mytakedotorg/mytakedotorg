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
import { INFO_HEADER_TABS_ENUM } from "./infoHeader";

interface DrawerProps {
  activeTab: INFO_HEADER_TABS_ENUM;
  isExpanded: boolean;
}
const Drawer: React.FC<DrawerProps> = (props) => {
  const drawerClass = props.isExpanded
    ? "header__drawer header__drawer--visible"
    : "header__drawer";
  const overlayClass = props.isExpanded
    ? "header__overlay header__overlay--visible"
    : "header__overlay";
  return (
    <>
      <div className={drawerClass}>todo</div>
      <div className={overlayClass} />
    </>
  );
};

export default Drawer;