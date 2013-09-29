package com.hermes.activity;

import android.view.View;

import com.hermes.reflection.AnnotatedActivity;
import com.hermes.reflection.Layout;
import com.hermes.tools.SoundTools;
import com.hermes.R;

@Layout(R.layout.activity_pronouns)
public class Pronouns extends AnnotatedActivity {

	public void me(View v) {
		SoundTools.playFileFromAssets("eu.mp3");
	}

	public void you(View v) {
		SoundTools.playFileFromAssets("voce.mp3");
	}
}
