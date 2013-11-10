package com.hermes.model;

import java.util.List;

import com.google.gson.annotations.Expose;

public class WordContainer {

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	@Expose
	public List<Word> words;

}
