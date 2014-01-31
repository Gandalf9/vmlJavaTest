package com.vml.test.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CSV_DATA")
public class Article {

	@Id
	private int id;

	private int articleid;

	private String attribute;

	private String value;

	private Short language;

	private Short type;

	public Article() {
	}

	public Article(int id, int articleid, String attribute, String value,
			Short language, Short type) {
		this.id = id;
		this.articleid = articleid;
		this.attribute = attribute;
		this.value = value;
		this.language = language;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public int getArticleid() {
		return articleid;
	}

	public String getAttribute() {
		return attribute;
	}

	public String getValue() {
		return value;
	}

	public Short getLanguage() {
		return language;
	}

	public Short getType() {
		return type;
	}
}
