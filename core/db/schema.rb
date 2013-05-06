# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended to check this file into your version control system.

ActiveRecord::Schema.define(:version => 20130506212811) do

  create_table "boards", :force => true do |t|
    t.string  "name"
    t.integer "user_id"
  end

  add_index "boards", ["user_id"], :name => "index_boards_on_user_id"

  create_table "item_boards", :force => true do |t|
    t.integer  "board_id"
    t.integer  "next_board_id"
    t.string   "type"
    t.string   "sound_file_name"
    t.string   "sound_content_type"
    t.integer  "sound_file_size"
    t.datetime "sound_updated_at"
    t.string   "image_file_name"
    t.string   "image_content_type"
    t.integer  "image_file_size"
    t.datetime "image_updated_at"
  end

  add_index "item_boards", ["board_id"], :name => "index_item_boards_on_board_id"

  create_table "users", :force => true do |t|
    t.string "name"
    t.string "email"
    t.string "password"
  end

end
