package com.hermes.model;

import java.util.List;

import com.google.gson.annotations.Expose;

public class BoardContainer {
	@Expose
	private List<Board> boards;

	public List<Board> getBoards() {
		return boards;
	}

}
