package com.hermes.tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;

import android.os.Environment;

public class Storage {

	public static void downlaodAndSaveFile(String urlFile, String fileName,
			OnFinishSaveFile onFinishSaveFile) {
		try {
			File root = Environment.getExternalStorageDirectory();
			File dir = new File(root.getAbsolutePath() + "/hermes");
			if (dir.exists() == false) {
				dir.mkdirs();
			}
			Log.i(String.format("Directory %s", dir.getAbsolutePath()));

			URL url = new URL(urlFile);
			File file = new File(dir, fileName);
			Log.i(String.format("Exists file ? %b", file.exists()));

			URLConnection ucon = url.openConnection();
			InputStream is = ucon.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);

			ByteArrayBuffer baf = new ByteArrayBuffer(5000);
			int current = 0;
			while ((current = bis.read()) != -1) {
				baf.append((byte) current);
			}

			FileOutputStream fos = new FileOutputStream(file);
			fos.write(baf.toByteArray());
			fos.flush();
			fos.close();
			onFinishSaveFile.onFinishSaveFile(file.getAbsolutePath());
		} catch (IOException e) {
			Log.e(String.format("Error downloading file %s", e));
		}
	}
}
