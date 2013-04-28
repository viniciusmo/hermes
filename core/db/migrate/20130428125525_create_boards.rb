class CreateBoards < ActiveRecord::Migration
  
  def self.up
    create_table :boards do |t|
      t.string :name
      t.integer :user_id
    end
    add_index(:boards , :user_id)
  end

  def self.down
  	 drop_table :boards  
  end
end
