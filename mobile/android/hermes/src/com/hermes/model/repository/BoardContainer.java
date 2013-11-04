package com.hermes.model.repository;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.hermes.model.Board;

public class BoardContainer {
	@Expose
	private List<Board> boards;

	public List<Board> getBoards() {
		return boards;
	}

}
