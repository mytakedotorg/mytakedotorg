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
import * as express from "express";
import { NextFunction, Request, Response } from "express";
const ReactDOMServer = require("react-dom/server");
import { decodeSocial } from "./common/social/social";
import { socialHeader } from "./common/social/SocialHeader";
import { Routes } from "./java2ts/Routes";
// Require routes
import { AspectRatio, RenderQueue } from "./renderer";
require("source-map-support").install();
const logger = require("morgan");
const app = express();

if (app.get("env") === "production") {
  app.set("trust proxy", 1); // trust first proxy
  app.use(logger("combined"));
} else {
  app.use(logger("dev"));
}

const ARG = "arg";
const DOT_PNG = ".png";

function renderHandler(ar: AspectRatio): express.Handler {
  return async (req, res) => {
    try {
      const risonPng = req.params[ARG];
      const rison = risonPng.slice(0, -DOT_PNG.length);
      const buf = await RenderQueue.render(rison, ar);
      res.contentType("image/png").send(buf);
    } catch (error) {
      logErrorAndSend404(req, error, res);
    }
  };
}
app.use(`${Routes.PATH_NODE_SOCIAL_IMAGE}:${ARG}`, renderHandler("facebook"));
app.use(
  `${Routes.PATH_NODE_SOCIAL_IMAGE_TWITTER}:${ARG}`,
  renderHandler("twitter")
);

app.use(`${Routes.PATH_NODE_SOCIAL_HEADER}:${ARG}`, async (req, res) => {
  try {
    const rison = req.params[ARG];
    const social = decodeSocial(rison);
    const html = ReactDOMServer.renderToString(
      await socialHeader(social, rison)
    );
    res.contentType("text/plain").send(html);
  } catch (error) {
    logErrorAndSend404(req, error, res);
  }
});

function logErrorAndSend404(req: Request, error: any, res: Response) {
  console.warn("#####################");
  console.warn(req.originalUrl);
  console.warn(error.stack);
  res.status(404).end();
}

declare global {
  interface Error {
    status?: number;
  }
}

// catch 404 and forward to error handler
app.use(function (req: Request, res: Response, next: NextFunction) {
  var err = new Error("Not Found");
  err.status = 404;
  next(err);
});

// development error handler will print stacktrace
if (app.get("env") === "development") {
  app.use(function (
    err: Error,
    req: Request,
    res: Response,
    next: NextFunction
  ) {
    res.status(err.status || 500);
    res.json({
      message: err.message,
      error: err,
    });
  });
}

// production error handler will not leak stacktrace
app.use(function (err: Error, req: Request, res: Response, next: NextFunction) {
  res.status(err.status || 500);
  res.json({
    message: err.message,
    error: err,
  });
});

module.exports = app;
