package com.hermes.model;

import java.io.Serializable;
import java.util.List;

public class Board implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<ItemBoard> itens;

	public Board(List<ItemBoard> itens) {
		this.itens = itens;
	}

	public List<ItemBoard> getItens() {
		return itens;
	}

}
