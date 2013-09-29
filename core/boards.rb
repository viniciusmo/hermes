require "./app"

class Boards < Sinatra::Base
  get '/boards' do
	content_type :json
    {boards: Board.all}.to_json
  end
end
