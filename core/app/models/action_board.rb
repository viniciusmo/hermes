class ActionBoard < Action
	attr_accessible :path_image, :board_id, :next_board_id
	validates :next_board_id, presence: true
	validates :path_image, presence: true
	validates :board_id, presence: true
end