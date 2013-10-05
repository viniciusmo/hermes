package com.hermes.model;

import com.hermes.model.orm.Entity;

public class Version extends Entity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
