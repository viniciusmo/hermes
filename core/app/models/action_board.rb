class ActionBoard < Action
	attr_accessible :path_image, :board_id, :next_board_id
	validates :next_board_id, presence: true
end