require 'test_helper'
require 'factory_girl'

class BoardTest < ActiveSupport::TestCase
   test "should save board without parameters" do
     board = FactoryGirl.build(:board)
     board.save
     board_persist = Board.find(board.id)
     assert_equal(board_persist.name,board.name)
     assert_equal(board_persist.column,board.column)
     assert_equal(board_persist.line,board.line)
     assert_equal(board_persist.user_id,board.user_id)
   end
   
   test "delete board" do
     board = FactoryGirl.create(:board)
     assert Board.delete(board.id)
   end

   test "update board" do
     board = FactoryGirl.create(:board)
     board.update_attributes(:name => "Nome atualizado",:column => 2,:line => 2,:user_id => 2)
     board_update = Board.find(board.id)
     assert_equal(board_update.name,board.name)
     assert_equal(board_update.column,board.column)
     assert_equal(board_update.line,board.line)
     assert_equal(board_update.user_id,board.user_id) 
   end
end
