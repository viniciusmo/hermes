package com.hermes.model.repository;

import com.hermes.model.Board;

public class BoardRepository {

	public static BoardContainer boardContainer;

	public static Board createBoardByCategorie(String categorie) {
		for (Board board : boardContainer.getBoards()) {
			if (board.getCategorie().equals(categorie)) {
				return board;
			}
		}
		return null;
	}

	public static BoardContainer getBoardContainer() {
		return boardContainer;
	}

	public static void setBoardContainer(BoardContainer boardContainer) {
		BoardRepository.boardContainer = boardContainer;
	}

}
