class ItemBoardsController < ApplicationController
  # GET /item_boards
  # GET /item_boards.json
  def index
    @item_boards = ItemBoard.all
    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @item_boards }
    end
  end

  # GET /item_boards/1
  # GET /item_boards/1.json
  def show
    @item_board = ItemBoard.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @item_board }
    end
  end

  # GET /item_boards/new
  # GET /item_boards/new.json
  def new
    @item_board = ItemBoard.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @item_board }
    end
  end

  # GET /item_boards/1/edit
  def edit
    @item_board = ItemBoard.find(params[:id])
  end

  # POST /item_boards
  # POST /item_boards.json
  def create
    @item_board = ItemBoard.new(params[:item_board])

    respond_to do |format|
      if @item_board.save
        format.html { redirect_to @item_board, notice: 'Item board was successfully created.' }
        format.json { render json: @item_board, status: :created, location: @item_board }
      else
        format.html { render action: "new" }
        format.json { render json: @item_board.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /item_boards/1
  # PUT /item_boards/1.json
  def update
    @item_board = ItemBoard.find(params[:id])

    respond_to do |format|
      if @item_board.update_attributes(params[:item_board])
        format.html { redirect_to @item_board, notice: 'Item board was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @item_board.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /item_boards/1
  # DELETE /item_boards/1.json
  def destroy
    @item_board = ItemBoard.find(params[:id])
    @item_board.destroy

    respond_to do |format|
      format.html { redirect_to item_boards_url }
      format.json { head :no_content }
    end
  end
end
