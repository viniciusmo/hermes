class AddAttachmentImageToItemBoards < ActiveRecord::Migration
  def self.up
    change_table :item_boards do |t|
      t.attachment :image
    end
  end

  def self.down
    drop_attached_file :item_boards, :image
  end
end
