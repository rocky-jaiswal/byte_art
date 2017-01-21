'use strict';

const axios = require('axios');

class HTTPHelper {

  createSVG (triangles) {
    return axios.post('http://localhost:3000/triangles', triangles);
  }

  postToTwitter (imgPath) {
    return axios.post('http://localhost:4567/tweet', { svgPath: imgPath });
  }

}

module.exports = new HTTPHelper();
