package com.hermes.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hermes.R;
import com.hermes.model.Board;
import com.hermes.model.ItemBoard;
import com.hermes.model.dao.BoardDao;
import com.hermes.reflection.AnnotatedActivity;
import com.hermes.reflection.Id;
import com.hermes.reflection.Layout;
import com.hermes.reflection.NoTitle;
import com.hermes.tools.ImageTools;
import com.hermes.tools.Log;

@NoTitle
@Layout(R.layout.activity_image_sound)
public class ImageSound extends AnnotatedActivity implements OnClickListener {
	@Id(R.id.board)
	private LinearLayout boardView;
	private Board board;
	private int index = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getBoardOfIntent();
		fillViewWithBoard();
	}

	private void fillViewWithBoard() {
		index = 0;
		for (int i = 0; i < board.getLines(); i++) {
			fillBoardView();
		}
	}

	private void fillBoardView() {
		LinearLayout boardLineView = (LinearLayout) getLayoutInflater()
				.inflate(R.layout.item_line_board, boardView, false);
		for (int j = 0; j < board.getCols(); j++) {
			ItemBoard itemBoard = board.getItemBoardList().get(index);
			fillBoardLineView(itemBoard, boardLineView);
			index++;
		}
		boardView.addView(boardLineView);
	}

	private void fillBoardLineView(ItemBoard item, LinearLayout boardLineView) {
		ImageView boardItemView = (ImageView) getLayoutInflater().inflate(
				R.layout.item_image_board, boardLineView, false);
		boardLineView.addView(boardItemView);
		Bitmap bitmap = ImageTools.getBitmapOfPath(item.getPathImage());
		boardItemView.setImageBitmap(bitmap);
		boardItemView.setTag(item);
		boardItemView.setOnClickListener(this);
	}

	private void getBoardOfIntent() {
		board = (Board) getIntent().getSerializableExtra("board");
		BoardDao boardDao = BoardDao.create();
		board = boardDao.load(board.getId());
		Log.i("Board " + board.getId());
		Log.i("Board " + board.getItemBoardList());
	}

	@Override
	public void onClick(View boardItemView) {
		ItemBoard itemBoard = (ItemBoard) boardItemView.getTag();
		itemBoard.doAction();
	}
}
