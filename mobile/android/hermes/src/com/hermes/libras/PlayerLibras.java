package com.hermes.libras;

import java.text.Normalizer;

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
		this.text = removeAccents(text);
	}

	public String removeAccents(String str) {
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		str = str.replaceAll("[^\\p{ASCII}]", "");
		return str;
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

	public void play() {
		startAnimation();
		doAnimation();
		stopAnimation();
	}

	public void startAnimation() {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				imgLibras.setVisibility(View.VISIBLE);
			}
		});
	}

	private void doAnimation() {
		for (int i = 0; i < text.length(); i++) {
			final char character = text.charAt(i);
			verifyCharacterAndChangeImage(character);
			sleep();
		}
	}

	private void verifyCharacterAndChangeImage(final char character) {
		if (isBetweenAandZ(character)) {
			changeImage(character);
		}
	}

	public void stopAnimation() {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				imgLibras.setVisibility(View.GONE);
			}
		});
	}

}
