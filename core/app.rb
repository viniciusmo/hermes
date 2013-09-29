# app.rb
require "sinatra"
require "sinatra/activerecord"
set :database, "sqlite3:///hermes.db"

class Item < ActiveRecord::Base
	belongs_to :board

	URL_PATH = "http://localhost:4567"

	def path_image
       URL_PATH+read_attribute(:path_image)
  	end

  	def path_sound
      URL_PATH+read_attribute(:path_sound)
  	end

end

class Board < ActiveRecord::Base
  has_many :items

  def as_json(options)
  	super(:include => [:items])
  end

end