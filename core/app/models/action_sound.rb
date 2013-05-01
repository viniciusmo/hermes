class ActionSound < Action
	attr_accessible :path_image, :board_id, :path_sound
	validates :path_sound, presence: true
end