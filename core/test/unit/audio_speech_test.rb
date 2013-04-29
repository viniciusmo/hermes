# -*- encoding: binary -*-
require 'test_helper'
require 'speech'

class AudioTest < ActiveSupport::TestCase
        def test_audio_to_text
	  audio = Speech::AudioToText.new(File.expand_path(File.join(File.dirname(__FILE__),"assets/teste.wav")))
      	  assert_equal "teste", audio.to_text
	end
end
