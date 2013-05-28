class ApplicationController < ActionController::Base
	protect_from_forgery

	def authenticate_user
		@user = User.find_by_email_and_password(params[:email],
        										Digest::MD5.hexdigest(params[:password]))
        unless @user
        	@result = Result.new ({:message => t(:sucess),:status => false})
        	respond_to do |format|
		      format.any { render :json => @result }
		    end
        end
        params[:user_id] = @user.id
	end
end
