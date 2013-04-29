require 'test_helper'

class TextControllerTest < ActionController::TestCase
  test "should text to sound" do
   get :converter, :phrase=>"teste"
   assert_response :success, @response.body	 
   assert_equal 'text/html', @response.content_type	
  end

end
