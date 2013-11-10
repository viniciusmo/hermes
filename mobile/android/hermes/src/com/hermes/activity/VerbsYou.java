package com.hermes.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.View;

import com.hermes.R;
import com.hermes.model.dao.BoardDao;
import com.hermes.reflection.AnnotatedActivity;
import com.hermes.reflection.Layout;
import com.hermes.tools.SoundTools;

@Layout(R.layout.activity_verbs_you)
public class VerbsYou extends AnnotatedActivity {
	private boolean isPlayingSound;

	public void want(View v) {
		String nameSound = "quer.mp3";
		String categorie = "quero";
		playSoundAndCallNextBoard(nameSound, categorie);
	}

	public void am(View v) {
		String nameSound = "esta.mp3";
		String categorie = "estou";
		playSoundAndCallNextBoard(nameSound, categorie);
	}

	public void go(View v) {
		String nameSound = "vai.mp3";
		String categorie = "vou";
		playSoundAndCallNextBoard(nameSound, categorie);
	}

	private void playSoundAndCallNextBoard(final String nameSound,
			final String categorie) {
		if (!isPlayingSound) {
			isPlayingSound = true;
			SoundTools.playFileFromAssets(nameSound,
					new OnCompletionListener() {
						@Override
						public void onCompletion(MediaPlayer mp) {
							Intent intent = new Intent(VerbsYou.this,
									ImageSound.class);
							intent.putExtra("board",
									BoardDao.findByCategorie(categorie));
							startActivity(intent);
							finish();
						}
					});
		}

	}
}
