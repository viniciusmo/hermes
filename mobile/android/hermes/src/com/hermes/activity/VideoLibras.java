package com.hermes.activity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.hermes.R;
import com.hermes.reflection.AnnotatedActivity;
import com.hermes.reflection.Id;
import com.hermes.reflection.Layout;
import com.hermes.reflection.NoTitle;
import com.hermes.tools.LibrasTools;

@NoTitle
@Layout(R.layout.activity_video_libras)
public class VideoLibras extends AnnotatedActivity {

	@Id(R.id.videoLibras)
	private VideoView videoLibras;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		execute();
	}

	private void execute() {
		videoLibras.setVideoPath(getPathVideo());
		MediaController mediaController = new MediaController(this);
		mediaController.setAnchorView(videoLibras);
		videoLibras.setMediaController(mediaController);
		videoLibras.requestFocus();
		videoLibras.start();
	}

	private String getPathVideo() {
		return LibrasTools.getVideoPath(getParameterText(),
				getApplicationContext());
	}

	private String getParameterText() {
		Bundle b = getIntent().getExtras();
		String text = b.getString("text");
		if (text == null) {
			throw new IllegalArgumentException("Parametro texto não veio");
		}
		return text;
	}
}
