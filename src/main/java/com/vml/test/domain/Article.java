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

	public Article(int articleid, String attribute, String value,
			Short language, Short type) {
		this.articleid = articleid;
		this.attribute = attribute;
		this.value = value;
		this.language = language;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArticleid() {
		return articleid;
	}

	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Short getLanguage() {
		return language;
	}

	public void setLanguage(Short language) {
		this.language = language;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", articleid=" + articleid
				+ ", attribute=" + attribute + ", value=" + value
				+ ", language=" + language + ", type=" + type + "]";
	}
}
