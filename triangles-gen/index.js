'use strict';

const CronJob    = require('cron').CronJob;
const Triangles  = require('./lib/triangles');
const HTTPHelper = require('./lib/http_helper');

const createAndTweet = () => {

  HTTPHelper.createSVG(Triangles.generate(1000, 500))
    .then((response) => HTTPHelper.postToTwitter(response.data.path))
    .then(console.log)
    .catch(console.error);
};

const job = new CronJob({
  cronTime: '* 00 * * * *',
  onTick: () => {
    createAndTweet();
  }
});

job.start();
