require "./app"

class Boards < Sinatra::Base
  get '/boards' do
	content_type :json
    @boards = Board.all
    @boards.to_json
  end
end

Boards.run!