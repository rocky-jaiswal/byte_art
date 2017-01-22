'use strict';

const CronJob    = require('cron').CronJob;
const HTTPHelper = require('./lib/http_helper');

const createAndTweet = () => {

  const funcs = [ HTTPHelper.createTriangles, HTTPHelper.createCircles ];

  funcs[Math.round(Math.random())].apply(null)
    .then((response) => HTTPHelper.postToTwitter(response.data.path))
    .then(console.log)
    .catch(console.error);
};

const job = new CronJob({
  cronTime: '05 * * * * *',
  onTick: () => {
    createAndTweet();
  }
});

job.start();
