module ApplicationHelper
	def flash_message
		messages = ""
		[:notice, :info, :warning, :error].each {|type|
			if flash[type]
				messages += "<p id=\"#{type}\">#{flash[type]}</p>"
			end
		}
		messages
	end
end
