package com.vml.test.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ArticleModelTest {

	private static final int ID = 1;
	private static final int ARTICLEID = 2;
	private static final String ATTRIBUTE = "att";
	private static final String VALUE = "something";
	private static final Short LANGUAGE = 3;
	private static final Short TYPE = 4;
	
	@Test
	public void setupArticleModelTest() {
		
		ArticleModel model = new ArticleModel(ID, ARTICLEID, ATTRIBUTE, VALUE, LANGUAGE, TYPE);

		assertThat(model.getId(), is(ID));
		assertThat(model.getArticleid(), is(ARTICLEID));
		assertThat(model.getAttribute(), is(ATTRIBUTE));
		assertThat(model.getValue(), is(VALUE));
		assertThat(model.getLanguage(), is(LANGUAGE));
		assertThat(model.getType(), is(TYPE));
	}
}
