package com.hermes.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;
import com.hermes.tools.SoundTools;

public class ItemBoard implements ItemActionable, Serializable {

	private static final long serialVersionUID = 1L;
	@SerializedName("path_sound")
	private String pathSound;
	@SerializedName("path_image")
	private String pathImage;

	public ItemBoard(String pathImage, String pathSound) {
		this.pathSound = pathSound;
		this.pathImage = pathImage;
	}

	public String getPathSound() {
		return pathSound;
	}

	public String getPathImage() {
		return pathImage;
	}

	@Override
	public void doAction() {
		SoundTools.playFileFromAssets(pathSound);
	}
}
