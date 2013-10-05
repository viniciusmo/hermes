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
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20130928004744) do

  create_table "boards", force: true do |t|
    t.string  "name"
    t.string  "categorie"
    t.integer "lines"
    t.integer "cols"
  end

  create_table "items", force: true do |t|
    t.integer "board_id"
    t.string  "path_image"
    t.string  "path_sound"
  end

  add_index "items", ["board_id"], name: "index_items_on_board_id"

end
