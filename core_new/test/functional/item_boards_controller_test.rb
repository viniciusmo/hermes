require 'test_helper'

class ItemBoardsControllerTest < ActionController::TestCase
  setup do
    @item_board = item_boards(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:item_boards)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create item_board" do
    assert_difference('ItemBoard.count') do
      post :create, item_board: { next_board_id: @item_board.next_board_id, path_image: @item_board.path_image, path_sound: @item_board.path_sound }
    end

    assert_redirected_to item_board_path(assigns(:item_board))
  end

  test "should show item_board" do
    get :show, id: @item_board
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @item_board
    assert_response :success
  end

  test "should update item_board" do
    put :update, id: @item_board, item_board: { next_board_id: @item_board.next_board_id, path_image: @item_board.path_image, path_sound: @item_board.path_sound }
    assert_redirected_to item_board_path(assigns(:item_board))
  end

  test "should destroy item_board" do
    assert_difference('ItemBoard.count', -1) do
      delete :destroy, id: @item_board
    end

    assert_redirected_to item_boards_path
  end
end
