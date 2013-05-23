require 'test_helper'
require 'factory_girl'

class UserTest < ActiveSupport::TestCase
   test "should not save user without parameters" do
    user = User.new 
    assert !user.save 
   end

   test "should save user" do
    user = FactoryGirl.build(:user)
    user.save
    user_persist = User.find(user.id)
    assert_equal(user_persist.id,user.id)
    assert_equal(user_persist.name,user.name)
    assert_equal(user_persist.email,user.email)
    assert_not_nil(user_persist.password)
   end
   
   test "delete user" do 
     user = FactoryGirl.create(:user)
     assert_not_nil(user)
     assert User.delete(user.id)
   end
   
   test "update user" do
     user = FactoryGirl.create(:user)
     user.update_attributes(:name => "Nome atualizado",:email => "Email atualizado",:password => "654321")
     user_update = User.find(user.id)
     assert_equal(user_update.name,"Nome atualizado")
     assert_equal(user_update.email,"Email atualizado")
     assert_equal(user_update.password,user.password)
   end
end
