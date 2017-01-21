require 'sinatra'
require_relative './tweet'

post '/tweet' do
  request.body.rewind  # in case someone already read it
  { imgpath: ::Byteart::Twitter::Tweet.new.create(JSON.parse(request.body.read)['svgPath']) }
end
