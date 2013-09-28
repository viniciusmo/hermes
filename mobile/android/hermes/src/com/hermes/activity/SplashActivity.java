package com.hermes.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.hermes.R;

public class SplashActivity extends Activity implements Runnable{

	@Override
	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash_screen);
		
		Handler handler = new Handler();
		handler.postDelayed(this, 5000);
	}
	
	
	@Override
	public void run(){
		startActivity(new Intent(this, MainMenu.class));
		finish();
	}
}
