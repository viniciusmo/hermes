class ItemBoardCall < ItemBoard
	attr_accessible :board_id, :image, :sound, :next_board_id

	has_attached_file :image ,
					  :path => "public/image/:id/:filename",
					  :url => "/image/:id/:filename"

	validates :next_board_id, presence: true
	validates :board_id, presence: true

	def as_json(options={})
  		super(:only => [:board_id, :next_board_id , :id , :type] ,:methods => [:path_image])
	end

	def path_image
		"#{Core::Application::HOST}#{self.image.url}"
	end

end