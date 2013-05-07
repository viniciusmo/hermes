class ItemBoardSound < ItemBoard
	attr_accessible :board_id, :image, :sound

	has_attached_file :image ,
					  :path => "public/image/:id/:filename",
					  :url => "/image/:id/:filename",
					  :default_url=> "/image_default.png"

	has_attached_file :sound,
					  :path => "public/sound/:id/:filename",
					  :url => "/sound/:id/:filename",
					  :default_url=> "/sound_default.mp3"

	validates :board_id , presence: true

	def as_json(options={})
  		super(:only => [:board_id, :id,:type] ,:methods => [:path_image , :path_sound])
	end

	def path_imagebcli
		"#{Core::Application::HOST}#{self.image.url}"
	end

	def path_sound
		"#{Core::Application::HOST}#{self.sound.url}"
	end
	
end