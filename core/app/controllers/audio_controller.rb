require 'speech'

class AudioController < ApplicationController
	def converter
		File.open("tmp/sounds/teste.wav",'wb') do |f|
			f.write params[:audio].read
		end
		audio = Speech::AudioToText.new("tmp/sounds/teste.wav")
		render :text =>  audio.to_text
	end
end
