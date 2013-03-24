package com.hermes.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.hermes.R;

public class TextoAudio extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_texto_audio);
	}
}
