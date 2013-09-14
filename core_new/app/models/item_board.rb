class ItemBoard < ActiveRecord::Base
  attr_accessible :board_id,:next_board_id, :path_image, :path_sound
  belongs_to :board
end
