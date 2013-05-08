class BoardsController < ApplicationController

  def index
    @boards = Board.find_all_by_user_id params[:user_id]
    @result = Result.new
    if @boards.count > 0 then
      @result.message = t(:sucess)
      @result.status = true
      @result.data = @boards
    else
      @result.message = t(:error)
      @result.status = false
    end
    respond_to do |format|
      format.any { render :json => @result }
    end
  end

  def show
    @result = Result.new
    begin
      @board = Board.find(params[:id])
      @result.message = t(:sucess)
      @result.status = true
      @result.data = @board
    rescue ActiveRecord::RecordNotFound => e
      @result.message = t(:board_not_found)
      @result.status = false
    end
    respond_to do |format|
      format.any { render :json => @result }
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

  def update
    @result = Result.new
    begin
      @board = Board.find(params[:id])
      if @board.update_attributes name: params[:name] then
        @result.message = t(:sucess)
        @result.status = true
      else
        @result.message = t(:error)
        @result.status = false
        @result.data = @user.errors
      end
    rescue ActiveRecord::RecordNotFound => e
      @result.message = t(:error)
      @result.status = false
      @result.data = e
    end
    respond_to do |format|
      format.any { render :json => @result }
    end
  end

  def destroy
    @result = Result.new
    begin
      @board = Board.find(params[:id])
      @board.destroy
      @result.message = t(:sucess)
      @result.status = true
    rescue ActiveRecord::RecordNotFound => e
      @result.message = t(:error)
      @result.status = false
      @result.data = e
    end
    respond_to do |format|
      format.any { render :json => @result }
    end
  end
end
