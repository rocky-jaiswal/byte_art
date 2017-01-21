'use strict';

const axios = require('axios');

class HTTPHelper {

  createSVG (triangles) {
    return axios.post('http://localhost:3000/triangles', triangles);
  }

}

module.exports = new HTTPHelper();
