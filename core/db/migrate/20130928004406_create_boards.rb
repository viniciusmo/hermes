class CreateBoards < ActiveRecord::Migration
  
  def up
    create_table :boards do |t|
      t.string :name
      t.string :categorie
      t.integer :lines
      t.integer :cols
    end
     Board.create(name: "Estou", categorie: "estou", lines:1, cols:3)
     Board.create(name: "Quero", categorie: "quero", lines:1, cols:3)
     Board.create(name: "Vou", categorie: "vou", lines:1, cols:3)
  end
 
  def down
    drop_table :boards
  end

end
