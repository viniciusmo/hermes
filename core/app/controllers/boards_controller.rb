class BoardsController < ApplicationController

  def index
    @boards = Board.all
    if @boards.count > 0 then
      @result = Result.new ({:message => t(:sucess),:status => true , :data =>@boards})
    else
      @result = Result.new ({:message => t(:error),:status => false})
    end
    respond_to do |format|
      format.any { render :json => @result }
    end
  end
  
end
