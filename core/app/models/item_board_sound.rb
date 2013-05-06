class ItemBoardSound < ItemBoard
	attr_accessible :board_id, :image, :sound

	has_attached_file :image ,
					  :path => "public/image/:id/:filename",
					  :url => "/image/:id/:filename"

	has_attached_file :sound,
					  :path => "public/sound/:id/:filename",
					  :url => "/sound/:id/:filename"

	def as_json(options={})
  		super(:only => [:board_id, :id,:type] ,:methods => [:path_image , :path_sound])
	end

	def path_image
		"#{Core::Application::HOST}#{self.image.url}"
	end

	def path_sound
		self.sound.url
	end
end