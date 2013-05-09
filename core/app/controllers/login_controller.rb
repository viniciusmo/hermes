require 'digest/md5'

class LoginController < ApplicationController

	def index
        
	end

	def logar
        @user = User.find_by_email_and_password(params[:user][:email],
        										Digest::MD5.hexdigest(params[:user][:password]))
        if @user
        	render :text => "ok"
        else
        	render :text => "nao"
        end
	end

end
