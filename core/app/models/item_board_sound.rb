class ItemBoardSound < ItemBoard
	has_attached_file :image
	has_attached_file :sound
	validates :board_id, presence: true

	def as_json(options={})
  		super(:only => [:image,:sound, :board_id, :path_sound , :id,:type])
	end

end