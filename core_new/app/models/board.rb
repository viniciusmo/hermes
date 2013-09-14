class Board < ActiveRecord::Base
  attr_accessible :name
  has_many :item_boards

  def as_json(options)
  	super(:include => [:item_boards])
  end

end
