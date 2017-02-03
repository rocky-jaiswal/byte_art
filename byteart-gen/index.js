'use strict';

const CronJob    = require('cron').CronJob;
const HTTPHelper = require('./lib/http_helper');

const getRandomInt = (min, max) => {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min)) + min;
}

const createAndTweet = () => {

  const funcs = [ HTTPHelper.createRings, HTTPHelper.createTriangles, HTTPHelper.createCircles ];

  funcs[getRandomInt(0, 3)].apply(null)
    .then((response) => HTTPHelper.postToTwitter(response.data.path))
    .then(console.log)
    .catch(console.error);
};

const job = new CronJob({
  cronTime: '10 10 * * * *',
  onTick: () => {
    // console.log('Ready ... Set .. Go!');
    createAndTweet();
  }
});

job.start();
