package com.hermes.tools;

import java.io.IOException;

import android.content.Context;
import android.content.res.AssetManager;

import com.hermes.exceptions.FailLoadAssetException;

public class LibrasTools {
	private static final String ANDROID_RESOURCE = "android.resource://";
	private static final String RAW = "/raw/";

	public static String getVideoPath(String text, Context context) {
		return ANDROID_RESOURCE + context.getPackageName() + RAW
				+ text.toLowerCase();
	}

	public static boolean hasVideo(String text, Context context) {
		AssetManager assetManager = ApplicationContext.context().getAssets();
		String path = text.toLowerCase() + ".mp4";
		try {
			String[] list = assetManager.list("video");
			for (String item : list) {
				if (item.equals(path)) {
					return true;
				}
			}
		} catch (IOException e) {
			throw new FailLoadAssetException();
		}
		return false;
	}
}
