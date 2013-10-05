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
	private int id;

	public ItemBoard(String pathImage, String pathSound) {
		this.pathSound = pathSound;
		this.pathImage = pathImage;
	}

	@Override
	public void doAction() {
		SoundTools.playFileFromPath(pathSound);
	}

	public String getPathSound() {
		return pathSound;
	}

	public void setPathSound(String pathSound) {
		this.pathSound = pathSound;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
