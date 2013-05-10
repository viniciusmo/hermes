class UsersController < ApplicationController
  attr_accessor :result

  def index
    @users = User.all
    if @users.count > 0 then
      @result = Result.new ({:message => t(:sucess),:status => true , :data =>@users.to_json(:except => :password)})
    else
      @result = Result.new ({:message => t(:error),:status => false})
    end
    respond_to do |format|
      format.any { render :json => @result}
    end
  end

  def show
    begin
      @user = User.find(params[:id])
      @result = Result.new ({:message => t(:sucess),:status => true , :data =>@user.to_json(:except => :password)})
    rescue ActiveRecord::RecordNotFound => e
      @result = Result.new ({:message => t(:user_not_found),:status => false})
    end
    respond_to do |format|
      format.any { render :json => @result }
    end
  end

  def new
    @user = User.new
  end

  def create
    @user = User.new(params[:user])
    if verify_recaptcha(:model => @user, :message => t(:error_captcha)) 
        if @user.save
          @result = Result.new ({:message => t(:sucess),:status => true})
        else
          @result = Result.new ({:message => t(:error),:status => false , :data => @user.errors})
        end
    end
    respond_to do |format|
      if @user.errors.any?
          format.html { render :new }
      else
          flash[:notice]=t(:user_save_with_sucess)
          format.html { redirect_to :controller => :authenticate ,:action => :index}
      end
      format.json { render :json => @result }
    end
  end

  def update
    @result = Result.new
    begin
      @user = User.find(params[:id])
      if @user.update_attributes params[:user] then
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
      @user = User.find(params[:id])
      @user.destroy
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
