package com.vml.test.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ArticleTest {

	private static final int ID = 1;
	private static final int ARTICLEID = 2;
	private static final String ATTRIBUTE = "att";
	private static final String VALUE = "something";
	private static final Short LANGUAGE = 3;
	private static final Short TYPE = 4;
	
	@Test
	public void setupArticleTest() {
		
		Article article = new Article(ID, ARTICLEID, ATTRIBUTE, VALUE, LANGUAGE, TYPE);

		assertThat(article.getId(), is(ID));
		assertThat(article.getArticleid(), is(ARTICLEID));
		assertThat(article.getAttribute(), is(ATTRIBUTE));
		assertThat(article.getValue(), is(VALUE));
		assertThat(article.getLanguage(), is(LANGUAGE));
		assertThat(article.getType(), is(TYPE));
	}
}
