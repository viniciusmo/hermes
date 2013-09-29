package com.hermes.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.google.gson.Gson;
import com.hermes.R;
import com.hermes.model.repository.BoardContainer;
import com.hermes.tools.WebClient;

public class SplashActivity extends Activity implements Runnable {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash_screen);

		Handler handler = new Handler();
		handler.postDelayed(this, 5000);
		new Thread() {
			public void run() {
				String result = WebClient
						.getContent("http://tccteste.no-ip.biz:9292/boards");
				BoardContainer boardContainer = new Gson().fromJson(result,
						BoardContainer.class);
				System.out.println(boardContainer.getBoards().get(0).getName());
			}
		}.start();
	}

	@Override
	public void run() {
		startActivity(new Intent(this, MainMenu.class));
		finish();
	}
}
