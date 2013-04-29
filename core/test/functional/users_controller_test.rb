require 'test_helper'
require 'factory_girl'
FactoryGirl.find_definitions

class UserControllerTest < ActionController::TestCase
  setup do
    @user = FactoryGirl.build(:user)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:users)
  end

  test "should create user" do
   assert_difference("User.count") do
	 post :create,  email: @user.email, name: @user.name, password: @user.password
   end
  end

  test "should show user" do
    get :show, id: @user
    assert_response :success
  end

  test "should update user" do
    user = FactoryGirl.create(:user)
    put :update, id: user.id, email: user.email, name: 'teste', password: user.password 
#    assert_equal("teste",user.name) 
 end

  test "should destroy user" do
    assert_difference("User.count", 0) do
      delete :destroy, id: @user
    end
  end
end
