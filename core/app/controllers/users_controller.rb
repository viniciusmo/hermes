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
      format.any { render :json => @result }
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


  # POST /users
  # POST /users.json
  def create
    @user = User.new
    @user.
    respond_to do |format|
      if @user.save
        format.html { redirect_to @user, notice: 'User was successfully created.' }
        format.json { render json: @user, status: :created, location: @user }
      else
        format.html { render action: "new" }
        format.json { render json: @user.errors, status: :unprocessable_entity }
      end
    end
  end
  
  def update
    @user = User.find(params[:id])

    respond_to do |format|
      if @user.update_attributes(params[:user])
        format.html { redirect_to @user, notice: 'User was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @user.errors, status: :unprocessable_entity }
      end
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
