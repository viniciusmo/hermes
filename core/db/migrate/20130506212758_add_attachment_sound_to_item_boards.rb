class AddAttachmentSoundToItemBoards < ActiveRecord::Migration
  def self.up
    change_table :item_boards do |t|
      t.attachment :sound
    end
  end

  def self.down
    drop_attached_file :item_boards, :sound
  end
end
