require 'digest/md5'
class AuthenticateController < ApplicationController

	def index  
	end
	
	def login
        @user = User.find_by_email_and_password(params[:user][:email],
        										Digest::MD5.hexdigest(params[:user][:password]))
        if @user
            session[:user] = @user
        	render :text => "ok"
        else
        	flash[:error] = t(:error_login)
        	render :index
        end
	end

end
