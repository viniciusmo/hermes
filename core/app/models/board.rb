class Board < ActiveRecord::Base
   attr_accessible :name , :column , :line , :user_id
   belongs_to :user
   has_many :item_boards
end
