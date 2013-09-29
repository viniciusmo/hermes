class CreateBoards < ActiveRecord::Migration
  
  def up
    create_table :boards do |t|
      t.string :name
      t.string :categorie
    end
     Board.create(name: "Estou", categorie: "estou")
     Board.create(name: "Quero", categorie: "quero")
     Board.create(name: "Vou", categorie: "vou")
  end
 
  def down
    drop_table :boards
  end

end
