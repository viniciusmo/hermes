class ItemBoardCall < Action
	attr_accessible :path_image, :board_id, :next_board_id
	validates :next_board_id, presence: true
	validates :path_image, presence: true
	validates :board_id, presence: true

	def as_json(options={})
  		super(:only => [:path_image, :board_id, :next_board_id , :id , :type])
	end

end