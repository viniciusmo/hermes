package com.hermes.libras;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.hermes.tools.ImageTools;
import com.hermes.tools.Log;

public class PlayerLibras {
	private Activity activity;
	private ImageView imgLibras;
	private String text;
	private static int TIME_SLEEP_IN_SECONDS = 1000 * 2;

	public PlayerLibras(Activity activity, ImageView imgLibras, String text) {
		this.activity = activity;
		this.imgLibras = imgLibras;
		this.text = text;
	}

	private void sleep() {
		try {
			Thread.sleep(TIME_SLEEP_IN_SECONDS);
		} catch (InterruptedException e) {
			Log.e("Sleep error");
		}
	}

	private boolean isBetweenAandZ(char character) {
		if (character >= 'A' && character <= 'Z') {
			return true;
		}
		return false;
	}

	private void changeImage(final char character) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				imgLibras.setImageBitmap(ImageTools
						.getBitmapOfAssetsFolder(character + ".jpg"));
			}
		});
	}

	private void verifyCharacterAndChangeImage(final char character) {
		if (isBetweenAandZ(character)) {
			changeImage(character);
		}
	}

	public void startAnimation() {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				imgLibras.setVisibility(View.VISIBLE);
			}
		});
	}

	public void stopAnimation() {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				imgLibras.setVisibility(View.GONE);
			}
		});
	}

	public void play() {
		startAnimation();
		for (int i = 0; i < text.length(); i++) {
			final char character = text.charAt(i);
			verifyCharacterAndChangeImage(character);
			sleep();
		}
		stopAnimation();
	}
}
