require 'speech'

class AudioController < ApplicationController
	def converter
		audio = Speech::AudioToText.new(params[:audio].tempfile.path)
		render :text =>  audio.to_text
	end
end
