package com.hermes.model;

public class ItemBoardCall extends ItemBoard implements ItemActionable {

	private Board nextBoard;

	public ItemBoardCall(String pathSound, String pathImage, Board nextBoard) {
		super(pathSound, pathImage);
		this.nextBoard = nextBoard;
	}

	public Board getNextBoard() {
		return nextBoard;
	}

	@Override
	public void doAction() {

	}

}
