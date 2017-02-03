'use strict';

const axios      = require('axios');
const Config     = require('config');
const Triangles  = require('./triangles');

class HTTPHelper {

  createTriangles () {
    return axios.post(Config.get('services.svgGeneratorUrl') + '/triangles', Triangles.generate(1000, 500));
  }

  createRings () {
    return axios.post(Config.get('services.svgGeneratorUrl') + '/rings');
  }

  createCircles () {
    return axios.post(Config.get('services.svgGeneratorUrl') + '/circles');
  }

  postToTwitter (imgPath) {
    return axios.post(Config.get('services.tweetManagerUrl'), { svgPath: imgPath });
  }

}

module.exports = new HTTPHelper();
