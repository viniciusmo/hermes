package com.hermes.activity;

import java.net.URLEncoder;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.hermes.R;

public class TextSound extends Activity implements
		android.view.View.OnClickListener {
	private static final String AUDIO_PATH = "http://10.0.2.2:3000/text/converter?phrase=";
	private MediaPlayer mediaPlayer;
	private Button btnTextToAudio;
	private EditText textToAudio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_text_audio);
		btnTextToAudio = (Button) findViewById(R.id.text_btn_image_to_audio);
		textToAudio = (EditText) findViewById(R.id.text_to_audio);
		btnTextToAudio.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		try {
			String url = getURL();
			Log.i(this.getClass().getSimpleName(),
					String.format("A url enviada foi %s", url));
			playAudio(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getURL() {
		String text = textToAudio.getText().toString();
		String textEscaped = URLEncoder.encode(text);
		return AUDIO_PATH + textEscaped;
	}

	private void playAudio(String url) throws Exception {
		mediaPlayer = new MediaPlayer();
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mediaPlayer.setDataSource(url);
		mediaPlayer.prepare();
		mediaPlayer.start();
	}
}
