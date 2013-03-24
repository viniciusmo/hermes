package com.hermes.view;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.hermes.R;

public class TextoAudio extends Activity implements
		android.view.View.OnClickListener {
	private static final String AUDIO_PATH = "http://127.0.0.1:3000/text/converter?phrase=";
	private MediaPlayer mediaPlayer;

	private Button btnTextToAudio;
	private EditText textToAudio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_texto_audio);
		btnTextToAudio = (Button) findViewById(R.id.text_btn_image_to_audio);
		textToAudio = (EditText) findViewById(R.id.text_to_audio);
		btnTextToAudio.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		try {
			playAudio(getURL());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getURL() {
		return AUDIO_PATH + textToAudio.getText().toString();
	}

	private void playAudio(String url) throws Exception {
		mediaPlayer = new MediaPlayer();
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mediaPlayer.setDataSource(this, Uri.parse(url));
		mediaPlayer.prepare();
		mediaPlayer.start();

	}
}
