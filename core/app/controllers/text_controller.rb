# encoding: utf-8
class TextController < ApplicationController
  def converter
     tts = Tts.new(params[:phrase])
     response.headers['Content-Type'] = 'audio/mpeg'
     render :text =>  tts.convert_to_audio("pt-BR")
  end
end