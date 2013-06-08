package com.hermes.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.hermes.R;
import com.hermes.model.repository.BoardRepository;
import com.hermes.tools.ApplicationContext;

public class MainMenu extends Activity implements
		android.view.View.OnClickListener {
	private Button btnTextToAudio;
	private Button btnImageToAudio;
	private Button btnAudioToLibras;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		ApplicationContext.setContext(this);
		setContentView(R.layout.activity_main_menu);
		initComponents();
		setListenersAllButtons();
	}

	private void setListenersAllButtons() {
		btnImageToAudio.setOnClickListener(this);
		btnTextToAudio.setOnClickListener(this);
		btnAudioToLibras.setOnClickListener(this);
	}

	private void initComponents() {
		btnImageToAudio = (Button) findViewById(R.id.btn_image_to_audio);
		btnTextToAudio = (Button) findViewById(R.id.btn_text_to_audio);
		btnAudioToLibras = (Button) findViewById(R.id.btn_audio_to_libras);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_audio_to_libras:
			startActivity(new Intent(this, SpeechLibras.class));
			break;
		case R.id.btn_text_to_audio:
			startActivity(new Intent(this, TextSound.class));
			break;
		case R.id.btn_image_to_audio:
			Intent intent = new Intent(this, ImageSound.class);
			intent.putExtra("board", new BoardRepository().createMainBoard());
			startActivity(intent);
			break;
		}
	}

}
