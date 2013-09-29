package com.hermes.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Board implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String categorie;

	@SerializedName("items")
	private List<ItemBoard> itens;

	public Board(List<ItemBoard> itens) {
		this.itens = itens;
	}

	public List<ItemBoard> getItens() {
		return itens;
	}

	public String getName() {
		return name;
	}

	public String getCategorie() {
		return categorie;
	}

}
