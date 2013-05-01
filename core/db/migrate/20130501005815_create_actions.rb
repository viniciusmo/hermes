class CreateActions < ActiveRecord::Migration
  
  def self.up
    create_table :actions do |t|

      #common
      t.string   :path_image
      t.integer  :board_id

      # if is a ActionSound
      t.string   :path_sound

      # if is a ActionBoard
      t.integer  :next_board_id

      # required for STI
      t.string 	 :type
    end
    add_index(:actions , :board_id)
  end

  def self.down
    drop_table :actions
  end

end
