package com.hermes.activity;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.hermes.R;
import com.hermes.libras.PlayerLibras;
import com.hermes.reflection.AnnotatedActivity;
import com.hermes.reflection.Id;
import com.hermes.reflection.Layout;
import com.hermes.reflection.NoTitle;
import com.hermes.tools.ApplicationContext;
import com.hermes.tools.LibrasTools;
import com.hermes.tools.Log;

@NoTitle
@Layout(R.layout.activity_speech_libras)
public class SpeechLibras extends AnnotatedActivity implements OnClickListener {
	private static final int RESULT_SPEECH = 1;
	@Id(R.id.btn_speak)
	private ImageButton btnSpeak;
	@Id(R.id.img_libras)
	private ImageView imgLibras;
	@Id(R.id.audio_btn_libras_to_video)
	private ImageButton btnVideo;

	private String text;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		btnSpeak.setOnClickListener(this);
		btnVideo.setOnClickListener(this);
		btnVideo.setVisibility(View.GONE);
	}

	@Override
	protected void onRestart() {
		btnVideo.setVisibility(View.GONE);
		super.onRestart();
	}

	private void playLibras() {
		Log.i(String.format("Texto capturado foi %s", text));
		PlayerLibras player = new PlayerLibras(this, imgLibras, text);
		player.play();
	}

	private void doTratamentWithTextCapturedAndPlayLibras(int resultCode,
			Intent data) {
		if (resultCode == RESULT_OK && null != data) {
			final ArrayList<String> texts = data
					.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			final Activity currentActivity = this;
			new Thread() {
				public void run() {
					text = texts.get(0).toUpperCase(Locale.getDefault());
					playLibras();
<<<<<<< HEAD
					if (LibrasTools.hasVideo(text, getApplicationContext())) {
						currentActivity.runOnUiThread(new Runnable() {
							@Override
							public void run() {
								btnVideo.setVisibility(View.VISIBLE);
							}
						});
					}
=======
					currentActivity.runOnUiThread(new Runnable() {
						@Override
						public void run() {
							if (LibrasTools.hasVideo(text,
									getApplicationContext())) {
								btnVideo.setVisibility(View.VISIBLE);
							}
						}
					});
>>>>>>> heroku
				}
			}.start();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case RESULT_SPEECH:
			if (resultCode == RESULT_OK && null != data) {
				doTratamentWithTextCapturedAndPlayLibras(resultCode, data);
			}
			break;
		}
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btn_speak:
			Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
			intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "pt-BR");
			try {
				btnVideo.setVisibility(View.GONE);
				startActivityForResult(intent, RESULT_SPEECH);
			} catch (ActivityNotFoundException a) {
				Toast t = Toast.makeText(ApplicationContext.context(),
						"Ops! Your device doesn't support Speech to Text",
						Toast.LENGTH_SHORT);
				t.show();
			}
			break;
		case R.id.audio_btn_libras_to_video:
			Intent intentVideoLibras = new Intent(this, VideoLibras.class);
			intentVideoLibras.putExtra("text", text);
			startActivity(intentVideoLibras);
			break;
		default:
			break;
		}
	}
}
