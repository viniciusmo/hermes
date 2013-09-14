class Board < ActiveRecord::Base
  attr_accessible :name
  has_many :item_boards
end
