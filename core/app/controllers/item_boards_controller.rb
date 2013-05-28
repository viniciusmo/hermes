class ItemBoardsController < ApplicationController
	before_filter :authenticate_user
 
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
end
