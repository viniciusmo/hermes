# app.rb
require 'rubygems'
require "sinatra"
require "sinatra/activerecord"

#set :database, "sqlite3:///hermes.db"

class Item < ActiveRecord::Base
	belongs_to :board

	URL_PATH = "http://tccfatec.herokuapp.com"

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

class Word < ActiveRecord::Base

end

get '/words/:text' do
  @word = Word.find_by_word params[:text]
  if @word then
    content_type :json
    {word: @word}.to_json
  else
    content_type :json
    {error: "word not found"}.to_json
  end
end

get '/words' do
  content_type :json
    {words: Word.all}.to_json
end

get '/boards' do
  content_type :json
    {boards: Board.all}.to_json
end

get '/boards/version' do
  content_type :json
    {name: 1}.to_json
end