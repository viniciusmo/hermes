require "./app"

class Boards < Sinatra::Base
  get '/boards' do
	content_type :json
    {boards: Board.all}.to_json
  end

  get '/boards/version' do
	content_type :json
    {name: 1}.to_json
  end

end
