class CreateItemBoards < ActiveRecord::Migration
	def self.up
    create_table :item_boards do |t|
      t.integer  :board_id
      t.integer  :next_board_id
    end
    add_index(:item_boards , :board_id)
  end

  def self.down
    drop_table :item_boards
  end

end
