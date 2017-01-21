FROM ruby:2.3.3-slim

RUN apt-get update
RUN apt-get install -y build-essential git imagemagick graphicsmagick

RUN gem install bundler

RUN mkdir /app
RUN mkdir -p /opt/byteart
WORKDIR /app

COPY . /app/
RUN bundle install --deployment --without development test

EXPOSE 4567

CMD ["bundle", "exec", "ruby", "lib/byteart/twitter/app.rb"]
