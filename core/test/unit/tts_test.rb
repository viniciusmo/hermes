require "test_helper"

class TtsTest < ActiveSupport::TestCase 
	def test_text_to_audio_not_nil
	  tts = Tts.new('teste')
          response =  tts.convert_to_audio("pt-BR")
	  assert_not_nil response
	end
end
