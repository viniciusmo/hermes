class UsersController < ApplicationController

  def index
    @users = User.all
    @result = Result.new
    if @users.count > 0 then
        @result.message = "Sucesso"
        @result.status = true
        @result.data = @users
    else
        @result.message = "Fail"
        @result.status = false
    end
    respond_to do |format|
      format.any { render :json => @users.to_json(:except => :password)}
    end
  end

  def show
    @result = Result.new
    begin
        @user = User.find(params[:id])
        @result.message = "Sucesso"
        @result.status = true
        @result.data = @user
    rescue ActiveRecord::RecordNotFound => e
        @result.message = "Usuario nao encontrado"
        @result.status = false
    end
    respond_to do |format|
      format.any { render :json => @result }
    end
  end

  def create
    @result = Result.new
    @user = User.new
    @user.name = params[:name]
    @user.email = params[:email]
    @user.password = params[:password]
    if @user.save
        @result.message = "Sucesso"
        @result.status = true
    else
        @result.message = "Ocorreu um erro"
        @result.status = false
        @result.data = @user.errors
    end
    respond_to do |format|
      format.any { render :json => @result }
    end
  end

  def update
    @result = Result.new
    begin
        @user = User.find(params[:id])
        if @user.update_attributes name: params[:name], email: params[:email], password: params[:password] then
            @result.message = "Sucesso"
            @result.status = true
        else
            @result.message = "Nao foi possivel realizar o update do usuario"
            @result.status = false
            @result.data = @user.errors
        end
    rescue ActiveRecord::RecordNotFound => e
        @result.message = "Usuario nao encontrado"
        @result.status = false
    end
    respond_to do |format|
      format.any { render :json => @result }
    end
  end

  def destroy
    @user = User.find(params[:id])
    @user.destroy
    respond_to do |format|
      format.html { redirect_to users_url }
      format.json { head :no_content }
    end
  end
end
