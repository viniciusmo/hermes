class ApplicationController < ActionController::Base
	protect_from_forgery

	def authenticate_user
		unless session[:user]
			flash[:error] = t(:error_restrict_area)
			redirect_to(:controller => :authenticate, :action => :index)
		else
			@current_user = session[:user]
		end
	end
end
