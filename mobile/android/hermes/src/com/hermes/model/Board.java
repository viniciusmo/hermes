package com.hermes.model;

import java.util.List;

public class Board {

	private List<ItemBoard> itens;

	public Board(List<ItemBoard> itens) {
		this.itens = itens;
	}

	public List<ItemBoard> getItens() {
		return itens;
	}

}
