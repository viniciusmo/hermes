package com.hermes.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.View;

import com.hermes.R;
import com.hermes.model.repository.BoardRepository;
import com.hermes.reflection.AnnotatedActivity;
import com.hermes.reflection.Layout;
import com.hermes.tools.SoundTools;

@Layout(R.layout.activity_verbs_me)
public class VerbsMe extends AnnotatedActivity {

	private boolean isPlayingSound;

	public void want(View v) {
		String nameSound = "quero.mp3";
		String categorie = "quero";
		playSoundAndCallNextBoard(nameSound, categorie);
	}

	public void am(View v) {
		String nameSound = "estou.mp3";
		String categorie = "estou";
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
							Intent intent = new Intent(VerbsMe.this,
									ImageSound.class);
							intent.putExtra("board", BoardRepository
									.createBoardByCategorie(categorie));
							startActivity(intent);
							finish();
						}
					});
		}

	}

	public void go(View v) {
		String nameSound = "vou.mp3";
		String categorie = "vou";
		playSoundAndCallNextBoard(nameSound, categorie);
	}
}
