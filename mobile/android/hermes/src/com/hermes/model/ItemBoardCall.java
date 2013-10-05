package com.hermes.model;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import com.hermes.activity.ImageSound;
import com.hermes.tools.ApplicationContext;
import com.hermes.tools.SoundTools;

public class ItemBoardCall extends ItemBoard implements ItemActionable,
		OnCompletionListener {

	private static final long serialVersionUID = 1L;
	private Board nextBoard;

	public ItemBoardCall(String pathSound, String pathImage, Board nextBoard) {
		super(pathSound, pathImage);
		this.nextBoard = nextBoard;
	}

	public Board getNextBoard() {
		return nextBoard;
	}

	@Override
	public void doAction() {
		SoundTools.playFileFromAssets(getPathSound(), this);
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		Intent intent = new Intent(ApplicationContext.context(),
				ImageSound.class);
		intent.putExtra("board", nextBoard);
		ApplicationContext.context().startActivity(intent);
	}
}
