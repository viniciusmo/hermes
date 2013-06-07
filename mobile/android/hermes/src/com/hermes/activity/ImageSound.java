package com.hermes.activity;

import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hermes.R;
import com.hermes.model.Board;
import com.hermes.reflection.Id;
import com.hermes.reflection.Layout;
import com.hermes.reflection.SimpleActivity;
import com.hermes.repository.BoardRepository;

@Layout(R.layout.activity_image_sound)
public class ImageSound extends SimpleActivity {
	@Id(R.id.board)
	private LinearLayout boardView;
	private Board mainBoard;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initMainBoard();
		try {
			fillViewWithBoard();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void fillViewWithBoard() throws IOException {

		for (int i = 0; i < 3; i++) {
			LinearLayout boardLineView = (LinearLayout) getLayoutInflater()
					.inflate(R.layout.item_line_board, null);
			for (int j = 0; j < 4; j++) {
				ImageView boardItemView = (ImageView) getLayoutInflater()
						.inflate(R.layout.item_image_board, null);
				boardLineView.addView(boardItemView);
				AssetManager assetManager = getAssets();
				InputStream istr = assetManager.open("1_estou_com_fome.jpg");
				Bitmap bitmap = BitmapFactory.decodeStream(istr);
				istr.close();
				boardItemView.setImageBitmap(bitmap);
			}
			boardView.addView(boardLineView);
		}

	}

	private void initMainBoard() {
		mainBoard = new BoardRepository(this).createMainBoard();
		ImageView itemView = new ImageView(this);
	}
}
