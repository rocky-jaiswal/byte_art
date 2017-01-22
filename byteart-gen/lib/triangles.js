'use strict';

const triangulate = require("delaunay-triangulate");

class Triangles {

  _getRandomInt (min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min)) + min;
  }

  generate (num, area) {
    const points = Array(num).fill(null).map((_ignored) => [this._getRandomInt(1, area), this._getRandomInt(1, area)]);
    return triangulate(points).map((face) => [points[face[0]], points[face[1]], points[face[2]]]);
  }


}

module.exports = new Triangles();
