package com.hermes.model;

public class ItemBoard implements ItemActionable {
	private String pathSound;
	private String pathImage;

	public ItemBoard(String pathSound, String pathImage) {
		this.pathSound = pathSound;
		this.pathImage = pathImage;
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

	@Override
	public void doAction() {

	}

}
