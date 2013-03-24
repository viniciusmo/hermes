package com.hermes.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.hermes.R;

public class MenuPrincipal extends Activity implements
		android.view.View.OnClickListener {
	private Button btnTextToAudio;
	private Button btnImageToAudio;
	private Button btnAudioToLibras;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_menu_principal);
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
			startActivity(new Intent(this, TextoAudio.class));
			break;
		case R.id.btn_text_to_audio:
			startActivity(new Intent(this, TextoAudio.class));
			break;
		case R.id.btn_image_to_audio:
			startActivity(new Intent(this, TextoAudio.class));
			break;
		}
	}

}
