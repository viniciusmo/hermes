package com.hermes.activity;

import android.view.View;

import com.hermes.reflection.AnnotatedActivity;
import com.hermes.reflection.Layout;
import com.hermes.tools.SoundTools;
import com.hermes.R;

@Layout(R.layout.activity_verbs_me)
public class VerbsMe extends AnnotatedActivity {

	public void want(View v) {
		SoundTools.playFileFromAssets("quero.mp3");
	}

	public void am(View v) {
		SoundTools.playFileFromAssets("estou.mp3");

	}

	public void go(View v) {
		SoundTools.playFileFromAssets("vou.mp3");

	}
}
