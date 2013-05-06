class ItemBoardCall < Action
	has_attached_file :image
	validates :next_board_id, presence: true
	validates :board_id, presence: true

	def as_json(options={})
  		super(:only => [:image, :board_id, :next_board_id , :id , :type])
	end

end