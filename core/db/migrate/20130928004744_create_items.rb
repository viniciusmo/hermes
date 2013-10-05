class CreateItems < ActiveRecord::Migration

  def up
    create_table :items do |t|
      t.integer  :board_id
      t.string :path_image
      t.string :path_sound
    end
    
    Item.create(board_id: 1, path_image: "/images/medo.png", path_sound:"/sounds/com_medo.mp3")
    Item.create(board_id: 1, path_image: "/images/sono.png", path_sound:"/sounds/com_sono.mp3")
    Item.create(board_id: 1, path_image: "/images/sede.png", path_sound:"/sounds/com_sede.mp3")
    Item.create(board_id: 2, path_image: "/images/brincar.png", path_sound:"/sounds/brincar.mp3")
    Item.create(board_id: 2, path_image: "/images/assistir_tv.png", path_sound:"/sounds/assistir_tv.mp3")
    Item.create(board_id: 2, path_image: "/images/banho.png", path_sound:"/sounds/tomar_banho.mp3")
    Item.create(board_id: 3, path_image: "/images/brincar.png", path_sound:"/sounds/brincar.mp3")
    Item.create(board_id: 3, path_image: "/images/assistir_tv.png", path_sound:"/sounds/assistir_tv.mp3")
    Item.create(board_id: 3, path_image: "/images/banho.png", path_sound:"/sounds/tomar_banho.mp3")

    add_index(:items,:board_id)
  end
 
  def down
    drop_table :items
  end

end
