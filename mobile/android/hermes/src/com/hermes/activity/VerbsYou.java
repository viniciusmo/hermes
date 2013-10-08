package com.hermes.activity;

import android.content.Intent;
import android.view.View;

import com.hermes.R;
import com.hermes.model.repository.BoardRepository;
import com.hermes.reflection.AnnotatedActivity;
import com.hermes.reflection.Layout;
import com.hermes.tools.SoundTools;

@Layout(R.layout.activity_verbs_you)
public class VerbsYou extends AnnotatedActivity {
	public void want(View v) {
		SoundTools.playFileFromAssets("quer.mp3");
		Intent intent = new Intent(this, ImageSound.class);
		intent.putExtra("board",
				BoardRepository.createBoardByCategorie("quero"));
		startActivity(intent);
		finish();
	}

	public void am(View v) {
		SoundTools.playFileFromAssets("esta.mp3");
		Intent intent = new Intent(this, ImageSound.class);
		intent.putExtra("board",
				BoardRepository.createBoardByCategorie("estou"));
		startActivity(intent);
		finish();
	}

	public void go(View v) {
		SoundTools.playFileFromAssets("vai.mp3");
		Intent intent = new Intent(this, ImageSound.class);
		intent.putExtra("board", BoardRepository.createBoardByCategorie("vou"));
		startActivity(intent);
		finish();
	}
}
