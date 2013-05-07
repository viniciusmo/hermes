class ItemController < ApplicationController

	def index
		@itens = ItemBoard.all
		@result = Result.new
		if @itens.count > 0 then
			@result.message = t(:sucess)
			@result.status = true
			@result.data = @itens
		else
			@result.message = t(:error)
			@result.status = false
		end
		respond_to do |format|
			format.any { render :json => @result}
		end
	end

	def show
		@result = Result.new
		begin
			@item = Item.find(params[:id])
			@result.message = t(:sucess)
			@result.status = true
			@result.data = @item
		rescue ActiveRecord::RecordNotFound => e
			@result.message = t(:item_not_found)
			@result.status = false
		end
		respond_to do |format|
			format.any { render :json => @result }
		end
	end

	def create
		puts params[:board_id]
		@result = Result.new
		@item = params[:type].constantize.new(params[:item])
		if @item.save
			@result.message = t(:sucess)
			@result.status = true
		else
			@result.message = t(:error)
			@result.status = false
			@result.data = @item.errors
		end
		respond_to do |format|
			format.any { render :json => @result}
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
