package com.hermes.sync;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hermes.R;
import com.hermes.model.Word;
import com.hermes.model.WordContainer;
import com.hermes.model.dao.WordDao;
import com.hermes.tools.ApplicationContext;
import com.hermes.tools.Log;
import com.hermes.tools.WebClient;

public class SyncWords implements Synceable {

	@Override
	public void doSync() {
		String url = ApplicationContext.res().getString(
				R.string.url_service_video_libras);
		String result = WebClient.getContent(url);
		Log.i("Carregando de " + url);

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		WordContainer wordContainer = gson
				.fromJson(result, WordContainer.class);
		WordDao wordDao = WordDao.create();

		if (wordDao.loadAll().isEmpty()) {
			Log.i("Carregando words");
			for (Word word : wordContainer.getWords()) {
				wordDao.insert(word);
			}
		}
		wordDao.getDatabase().close();
	}

}
