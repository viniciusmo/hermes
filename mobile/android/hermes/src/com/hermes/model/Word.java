package com.hermes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table WORD.
 */
public class Word {

	private Long id;
	@Expose
	private String word;
	@Expose
	@SerializedName("url_word")
	private String urlVideo;

	public Word() {
	}

	public Word(Long id) {
		this.id = id;
	}

	public Word(Long id, String word, String urlVideo) {
		this.id = id;
		this.word = word;
		this.urlVideo = urlVideo;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	/** Not-null value. */
	public String getWord() {
		return word;
	}

	/**
	 * Not-null value; ensure this value is available before it is saved to the
	 * database.
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/** Not-null value. */
	public String getUrlVideo() {
		return urlVideo;
	}

	/**
	 * Not-null value; ensure this value is available before it is saved to the
	 * database.
	 */
	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

}
