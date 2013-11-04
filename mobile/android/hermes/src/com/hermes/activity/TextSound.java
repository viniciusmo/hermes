package com.hermes.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.hermes.R;
import com.hermes.reflection.AnnotatedActivity;
import com.hermes.reflection.Id;
import com.hermes.reflection.Layout;
import com.hermes.reflection.NoTitle;
import com.viniciusmo.androidtextspeech.Language;
import com.viniciusmo.androidtextspeech.Speaker;
import com.viniciusmo.androidtextspeech.translate.OnCompleteLoad;

@Layout(R.layout.activity_text_audio)
@NoTitle
public class TextSound extends AnnotatedActivity implements
		android.view.View.OnClickListener, OnCompleteLoad {
	@Id(R.id.text_btn_image_to_audio)
	private ImageButton btnTextToAudio;
	@Id(R.id.text_to_audio)
	private EditText textToAudio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		btnTextToAudio.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		disableInputUser();
		String textForSpeech = textToAudio.getText().toString();
		Context context = this;
		OnCompleteLoad onCompleteLoad = new OnCompleteLoad() {
			@Override
			public void onCompleteLoaded() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						enableInputUser();
					}
				});
			}
		};
		Speaker.speack(textForSpeech, Language.PORTUGUESE_BR, context,
				onCompleteLoad);
	}

	private void disableInputUser() {
		btnTextToAudio.setEnabled(false);
		textToAudio.setEnabled(false);
	}

	private void enableInputUser() {
		btnTextToAudio.setEnabled(true);
		textToAudio.setEnabled(true);
	}

	@Override
	public void onCompleteLoaded() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				enableInputUser();
			}
		});
	}
}
