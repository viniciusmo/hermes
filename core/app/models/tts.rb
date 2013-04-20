require 'open-uri'

class Tts
    @@default_url = "http://translate.google.com/translate_tts"
    @@default_user_agent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.68 Safari/534.24"
    attr_accessor :text

    def initialize (text)
        @text = text
    end

    def self.server_url
      @@default_url 
    end

    def self.user_agent
      @@default_user_agent 
    end

    def to_url lang
      base = "#{Tts.server_url}?tl=#{lang}&q=#{URI.escape @text}"
    end

    def convert_to_audio lang
      url = self.to_url(lang)
      open(url, "User-Agent" => Tts.user_agent).read
    end

end