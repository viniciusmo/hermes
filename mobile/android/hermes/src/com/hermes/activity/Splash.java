package com.hermes.activity;

import android.content.Intent;
import android.os.Bundle;

import com.hermes.R;
import com.hermes.reflection.AnnotatedActivity;
import com.hermes.reflection.Layout;
import com.hermes.reflection.NoTitle;
import com.hermes.sync.SyncWebServices;
import com.hermes.tools.ApplicationContext;

@Layout(R.layout.activity_splash_screen)
@NoTitle
public class Splash extends AnnotatedActivity {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		ApplicationContext.setContext(this);
		new Thread() {
			public void run() {
				new SyncWebServices().doSync();
				startActivity(new Intent(Splash.this, MainMenu.class));
				finish();
			};
		}.start();
	}

}
