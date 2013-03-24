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
    url
  end
end

class String
  include Tts
end


class TextController < ApplicationController
  def converter
     url = params[:phrase].to_file "pt-BR"
     ua = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.68 Safari/534.24"
     response.headers['Cache-Control'] = "public, max-age=#{12.hours.to_i}"
     response.headers['Content-Type'] = 'audio/mpeg'
     render :text =>  open(url, "User-Agent" => ua).read
  end
end

