require 'sinatra'
require_relative './tweet'

post '/tweet' do
  content_type :json
  request.body.rewind  # in case someone already read it
  { imgpath: ::Byteart::Twitter::Tweet.new.create(JSON.parse(request.body.read)['svgPath']) }.to_json
end
