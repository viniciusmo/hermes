package com.hermes.libras;

import com.hermes.tools.ImageTools;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

public class PlayerLibras {
	private Activity activity;
	private ImageView imgLibras;
	private String text;

	public PlayerLibras(Activity activity, ImageView imgLibras, String text) {
		this.activity = activity;
		this.imgLibras = imgLibras;
		this.text = text;
	}

	public void play() {
		for (int i = 0; i < text.length(); i++) {
			final char character = text.charAt(i);
			activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					imgLibras.setImageBitmap(ImageTools
							.getBitmapOfAssetsFolder(character + ".jpg"));
				}
			});
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

			}
		}
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				imgLibras.setVisibility(View.GONE);
			}
		});
	}
}
