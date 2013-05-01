class Action < ActiveRecord::Base
	validates :path_image, presence: true
	validates :board_id, presence: true
end
