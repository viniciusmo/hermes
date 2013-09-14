class CreateItemBoards < ActiveRecord::Migration
  def change
    create_table :item_boards do |t|
      t.integer  :board_id
      t.string :path_image
      t.string :path_sound
      t.integer :next_board_id
      t.timestamps
    end
     add_index(:item_boards , :board_id)
  end
end

