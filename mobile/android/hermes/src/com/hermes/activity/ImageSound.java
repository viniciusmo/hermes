package com.hermes.activity;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.hermes.R;
import com.hermes.model.Board;
import com.hermes.repository.BoardRepository;

public class ImageSound extends Activity {
	private ImageView imageSound;
	private Board mainBoard;
	private BoardRepository boardRepository;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_sound);
		initBoardRepository();
		initMainBoard();
		try {
			fillViewWithBoard();
			fillViewWithBoard1();
			fillViewWithBoard2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void fillViewWithBoard() throws IOException {
		imageSound = (ImageView) findViewById(R.id.image_sound_1);

		AssetManager assetManager = getAssets();

		InputStream istr = assetManager.open("background.jpg");
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		istr.close();
		imageSound.setImageBitmap(bitmap);

	}

	private void fillViewWithBoard1() throws IOException {
		imageSound = (ImageView) findViewById(R.id.image_sound_2);

		AssetManager assetManager = getAssets();

		InputStream istr = assetManager.open("background.jpg");
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		istr.close();
		imageSound.setImageBitmap(bitmap);

	}

	private void fillViewWithBoard2() throws IOException {
		imageSound = (ImageView) findViewById(R.id.image_sound_3);

		AssetManager assetManager = getAssets();

		InputStream istr = assetManager.open("background.jpg");
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		istr.close();
		imageSound.setImageBitmap(bitmap);

	}

	private void initBoardRepository() {
		boardRepository = new BoardRepository(this);
	}

	private void initMainBoard() {
		mainBoard = boardRepository.createMainBoard();
	}
}
