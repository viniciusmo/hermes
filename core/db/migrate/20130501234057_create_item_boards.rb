class CreateItemBoards < ActiveRecord::Migration
	def self.up
    create_table :item_boards do |t|

      #common
      t.string   :path_image
      t.integer  :board_id

      # if is a ItemBoardSound
      t.string   :path_sound

      # if is a ItemBoardCall
      t.integer  :next_board_id

      # required for STI
      t.string 	 :type
    end
    add_index(:item_boards , :board_id)
  end

  def self.down
    drop_table :item_boards
  end

end
