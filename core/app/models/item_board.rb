class ItemBoard < ActiveRecord::Base

	attr_accessible :board_id, :image, :sound, :next_board_id

	has_attached_file :image ,
					  :path => "public/image/:id/:filename",
					  :url => "/image/:id/:filename",
					  :default_url=> "/image_default.png"

	has_attached_file :sound,
					  :path => "public/sound/:id/:filename",
					  :url => "/sound/:id/:filename",
					  :default_url=> "/sound_default.mp3"

	validates :board_id , presence: true
	belongs_to :board
	
	def as_json(options={})
  		super(:only => [:board_id, :id,:type, :next_board_id] ,:methods => [:path_image , :path_sound])
	end

	def path_image
		"#{Core::Application::HOST}#{self.image.url}"
	end

	def path_sound
		"#{Core::Application::HOST}#{self.sound.url}"
	end

end
