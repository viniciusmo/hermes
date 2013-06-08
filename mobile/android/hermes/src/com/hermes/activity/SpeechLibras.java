package com.hermes.activity;

import java.util.ArrayList;
import java.util.Locale;

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
import com.hermes.reflection.Id;
import com.hermes.reflection.Layout;
import com.hermes.reflection.NoTitle;
import com.hermes.reflection.SimpleActivity;
import com.hermes.tools.ApplicationContext;
import com.hermes.tools.Log;

@NoTitle
@Layout(R.layout.activity_speech_libras)
public class SpeechLibras extends SimpleActivity implements OnClickListener {
	private static final int RESULT_SPEECH = 1;
	@Id(R.id.btn_speak)
	private ImageButton btnSpeak;
	@Id(R.id.img_libras)
	private ImageView imgLibras;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		btnSpeak.setOnClickListener(this);
	}

	private void playLibras(String text) {
		Log.i(String.format("Texto capturado foi %s", text));
		PlayerLibras player = new PlayerLibras(this, imgLibras, text);
		player.play();
	}

	private void doTratamentWithTextCapturedAndPlayLibras(int resultCode,
			Intent data) {
		if (resultCode == RESULT_OK && null != data) {
			final ArrayList<String> text = data
					.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			new Thread() {
				public void run() {
					playLibras(text.get(0).toUpperCase(Locale.getDefault()));
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
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "pt-BR");
		try {
			startActivityForResult(intent, RESULT_SPEECH);
		} catch (ActivityNotFoundException a) {
			Toast t = Toast.makeText(ApplicationContext.context(),
					"Ops! Your device doesn't support Speech to Text",
					Toast.LENGTH_SHORT);
			t.show();
		}
	}
}
