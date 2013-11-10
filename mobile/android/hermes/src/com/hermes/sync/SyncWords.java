package com.hermes.sync;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hermes.R;
import com.hermes.tools.ApplicationContext;
import com.hermes.tools.WebClient;

public class SyncWords implements Synceable {

	@Override
	public void doSync() {
		String url = ApplicationContext.res().getString(
				R.string.url_service_video_libras);
		String result = WebClient.getContent(url);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
	}

}
