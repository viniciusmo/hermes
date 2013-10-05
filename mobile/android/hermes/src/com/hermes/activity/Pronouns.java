package com.hermes.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.View;

import com.hermes.R;
import com.hermes.reflection.AnnotatedActivity;
import com.hermes.reflection.Layout;
import com.hermes.tools.SoundTools;

@Layout(R.layout.activity_pronouns)
public class Pronouns extends AnnotatedActivity {

	public void me(View v) {
		final Intent intent = new Intent(Pronouns.this, VerbsMe.class);
		String fileSound = "eu.mp3";
		playSongAndCallNextIntent(intent, fileSound);
	}

	public void you(View v) {
		final Intent intent = new Intent(Pronouns.this, VerbsYou.class);
		String fileSound = "voce.mp3";
		playSongAndCallNextIntent(intent, fileSound);
	}

	private void playSongAndCallNextIntent(final Intent intent, String fileSound) {
		SoundTools.playFileFromAssets(fileSound, new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				startActivity(intent);
			}
		});
	}
}
