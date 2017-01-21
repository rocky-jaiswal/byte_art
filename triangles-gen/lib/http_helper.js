'use strict';

const axios  = require('axios');
const Config = require('config');

class HTTPHelper {

  createSVG (triangles) {
    return axios.post(Config.get('services.svgGeneratorUrl'), triangles);
  }

  postToTwitter (imgPath) {
    return axios.post(Config.get('services.tweetManagerUrl'), { svgPath: imgPath });
  }

}

module.exports = new HTTPHelper();
