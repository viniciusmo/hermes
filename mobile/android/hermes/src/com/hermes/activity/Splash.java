package com.hermes.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.hermes.R;
import com.hermes.model.repository.SyncBoards;
import com.hermes.reflection.AnnotatedActivity;
import com.hermes.reflection.Layout;
import com.hermes.reflection.NoTitle;
import com.hermes.tools.ApplicationContext;

@Layout(R.layout.activity_splash_screen)
@NoTitle
public class Splash extends AnnotatedActivity implements Runnable {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		ApplicationContext.setContext(this);
		Handler handler = new Handler();
		handler.postDelayed(this, 5000);
	}

	@Override
	public void run() {
		new Thread(new SyncBoards()).start();
		startActivity(new Intent(this, MainMenu.class));
		finish();
	}
}
