package com.vml.test.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CsvData {

	@Id
	private int id;
	
	private int articleId;
	
	private String attribute;
	
	private String value;
	
	private int language;
	
	private int type;
	
	public CsvData() {
	}
	
	public CsvData(int articleId, String attribute, String value, int language, int type) {
		this.articleId = articleId;
		this.attribute = attribute;
		this.value = value;
		this.language = language;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public int getArticleId() {
		return articleId;
	}

	public String getAttribute() {
		return attribute;
	}

	public String getValue() {
		return value;
	}

	public int getLanuguage() {
		return language;
	}

	public int getType() {
		return type;
	}
}
