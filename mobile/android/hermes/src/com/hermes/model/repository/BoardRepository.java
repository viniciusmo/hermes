package com.hermes.model.repository;

import com.hermes.model.Board;
import com.hermes.model.dao.BoardDao;
import com.hermes.model.dao.BoardDao.Properties;

public class BoardRepository {

	public static Board createBoardByCategorie(String categorie) {
		Board board = BoardDao.create().queryBuilder()
				.where(Properties.Categorie.eq(categorie)).unique();
		return board;
	}

}
