package com.hermes.tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.hermes.exceptions.FailLoadAssetException;

public class ImageTools {

	public static Bitmap getBitmapOfAssetsFolder(String path) {
		AssetManager assetManager = ApplicationContext.context().getAssets();
		InputStream istr;
		Bitmap bitmap = null;
		try {
			istr = assetManager.open(path);
			bitmap = BitmapFactory.decodeStream(istr);
			istr.close();
		} catch (IOException e) {
			throw new FailLoadAssetException();
		}
		return bitmap;
	}

	public static Bitmap getBitmapOfPath(String path) {
		InputStream istr;
		Bitmap bitmap = null;
		try {
			File file = new File(path);
			istr = new BufferedInputStream(new FileInputStream(file));
			bitmap = BitmapFactory.decodeStream(istr);
			istr.close();
		} catch (IOException e) {
			throw new FailLoadAssetException();
		}
		return bitmap;
	}
}
