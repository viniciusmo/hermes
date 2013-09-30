package com.hermes.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.gson.Gson;
import com.hermes.R;
import com.hermes.model.repository.BoardContainer;
import com.hermes.reflection.AnnotatedActivity;
import com.hermes.reflection.Layout;
import com.hermes.reflection.NoTitle;
import com.hermes.tools.WebClient;

@Layout(R.layout.activity_splash_screen)
@NoTitle
public class SplashActivity extends AnnotatedActivity implements Runnable {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		Handler handler = new Handler();
		handler.postDelayed(this, 5000);
		new Thread() {
			public void run() {
				String result = WebClient
						.getContent("http://192.168.0.3:9292/boards");
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
