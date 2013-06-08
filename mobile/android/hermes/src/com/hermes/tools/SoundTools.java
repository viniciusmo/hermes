package com.hermes.tools;

import java.io.IOException;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import com.hermes.exceptions.FailLoadAssetException;

public class SoundTools {

	public static void playFileFromAssets(String path,
			OnCompletionListener onCompletionListener) {
		AssetFileDescriptor afd;
		try {
			afd = ApplicationContext.context().getAssets().openFd(path);
			MediaPlayer player = new MediaPlayer();
			player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(),
					afd.getLength());
			player.setOnCompletionListener(onCompletionListener);
			player.prepare();
			player.start();
		} catch (IOException e) {
			throw new FailLoadAssetException();
		}
	}

	public static void playFileFromAssets(String path) {
		AssetFileDescriptor afd;
		try {
			afd = ApplicationContext.context().getAssets().openFd(path);
			MediaPlayer player = new MediaPlayer();
			player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(),
					afd.getLength());
			player.prepare();
			player.start();
		} catch (IOException e) {
			throw new FailLoadAssetException();
		}
	}
}
