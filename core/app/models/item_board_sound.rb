class ItemBoardSound < ItemBoard
	attr_accessible :path_image, :board_id, :path_sound
	validates :path_sound, presence: true
	validates :path_image, presence: true
	validates :board_id, presence: true

	def as_json(options={})
  		super(:only => [:path_image, :board_id, :path_sound , :id,:type])
	end

end