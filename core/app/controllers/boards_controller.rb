class BoardsController < ApplicationController
  before_filter :authenticate_user

  def index
    @board = Board.find_by_user_id(params[:user_id])
    if @board then
      @result = Result.new ({:message => t(:sucess),:status => true , :data =>@board.to_json(:items => @board.items)})
    else
      @result = Result.new ({:message => t(:error),:status => false})
    end
    respond_to do |format|
      format.any { render :json => @result }
    end
  end
end
