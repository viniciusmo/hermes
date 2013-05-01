class ActionSound < Action
	attr_accessible :path_image, :board_id, :path_sound
	validates :path_sound, presence: true
	validates :path_image, presence: true
	validates :board_id, presence: true
end