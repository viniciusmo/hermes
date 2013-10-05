package com.hermes.activity;

import android.content.Intent;
import android.view.View;

import com.hermes.R;
import com.hermes.model.repository.BoardRepository;
import com.hermes.reflection.AnnotatedActivity;
import com.hermes.reflection.Layout;
import com.hermes.tools.SoundTools;

@Layout(R.layout.activity_verbs_me)
public class VerbsMe extends AnnotatedActivity {

	public void want(View v) {
		SoundTools.playFileFromAssets("quero.mp3");
		Intent intent = new Intent(this, ImageSound.class);
		intent.putExtra("board",
				BoardRepository.createBoardByCategorie("quero"));
		startActivity(intent);
	}

	public void am(View v) {
		SoundTools.playFileFromAssets("estou.mp3");
		Intent intent = new Intent(this, ImageSound.class);
		intent.putExtra("board",
				BoardRepository.createBoardByCategorie("estou"));
		startActivity(intent);

	}

	public void go(View v) {
		SoundTools.playFileFromAssets("vou.mp3");
		Intent intent = new Intent(this, ImageSound.class);
		intent.putExtra("board", BoardRepository.createBoardByCategorie("vou"));
		startActivity(intent);
	}
}
