#http://localhost:3000/text/converter?phrase=teste
class TextController < ApplicationController
  def converter
   	 phrase = params[:phrase]
  	 phrase.to_file "pt-BR"
  end
end

# encoding: utf-8

def to_valid_fn fn
 fn.gsub(/[\x00\/\\:\*\?\"<>\|]/, '_')
end


module Tts
 @@default_url = "http://translate.google.com/translate_tts"
 def self.server_url url=nil
   return @@default_url if url.nil?
   @@default_url = url
 end

 def to_url lang
   require 'uri'
   langs = ["zh", "en", "it", "fr"]
   #raise "Not accepted language, accpeted are #{langs * ","}" unless langs.include? lang
   base = "#{Tts.server_url}?tl=#{lang}&q=#{URI.escape self}"
 end

 def to_file lang, file_name=nil
   require 'open-uri'
   file_name = to_valid_fn(self +".mp3") if file_name.nil?
   url = self.to_url(lang)
   ua = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.68 Safari/534.24"
   begin
     content = open(url, "User-Agent" => ua).read

     File.open("app/assets/sound/" + file_name, "wb") do |f|
       f.puts content
     end
   rescue Exception => error
     $stderr.puts("Internet error! #{error.message}")
     exit(1)
   end

 end
end

class String
 		include Tts	
end
