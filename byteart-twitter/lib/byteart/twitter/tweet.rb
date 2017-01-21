require 'twitter'
require 'mini_magick'

module Byteart
  module Twitter
    class Tweet

      def initialize
        @twitter_client = ::Twitter::REST::Client.new do |config|
          config.consumer_key        = 'tFScBlfmVQ6erbZZeVdssiklk'
          config.consumer_secret     = ENV['CONS_SECRET']
          config.access_token        = ENV['ACCESS_TOKEN']
          config.access_token_secret = ENV['ACCESS_SECRET']
        end
      end

      def create(img)
        @twitter_client.update_with_media('', File.new(convert_to_png(img)))
      end

      private

      def convert_to_png(img)
        image = ::MiniMagick::Image.new(img)
        image.format 'png'
        image.path
      end

    end
  end
end
