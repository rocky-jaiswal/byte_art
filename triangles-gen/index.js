'use strict';

const Triangles  = require('./lib/triangles');
const HTTPHelper = require('./lib/http_helper');

const triangles = Triangles.generate(1000, 500);

HTTPHelper.createSVG(triangles)
  .then((response) => console.log('Triangle created at - ' + response.data.name))
  .catch((err) => console.error(err));
