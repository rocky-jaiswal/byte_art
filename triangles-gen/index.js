'use strict';

const Triangles  = require('./lib/triangles');
const HTTPHelper = require('./lib/http_helper');

const triangles = Triangles.generate(1000, 500);

HTTPHelper.createSVG(triangles)
  .then((response) => HTTPHelper.postToTwitter(response.data.path))
  .then(console.log)
  .catch(console.error);
