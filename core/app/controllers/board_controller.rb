class BoardController < ApplicationController
  
  def index
  	respond_to do |format|
      format.any { render :json => "ok" }
    end
  end

  def create
    @result = Result.new
    @board = Board.new
    @board.name = params[:name]
    @board.user_id = params[:user_id]
    if @board.save
        @result.message = t(:sucess)
        @result.status = true
    else
        @result.message = t(:error)
        @result.status = false
        @result.data = @board.errors
    end
    respond_to do |format|
      format.any { render :json => @result }
    end
  end

end
