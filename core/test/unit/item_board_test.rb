require 'test_helper'

class ItemBoardTest < ActiveSupport::TestCase
   test "save item board" do
     item_board = ItemBoard.new
     item_board.board_id = 1
     item_board.next_board_id = 2
#     item_board.image = "imagem.png"
#     item_board.sound = "sound.mp3"
     assert item_board.save
   end
end
