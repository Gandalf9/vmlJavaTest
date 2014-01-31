package com.vml.test.transformer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.vml.test.domain.Article;
import com.vml.test.model.ArticleModel;

public class ArticleTransformerTest {

	private static final int ID = 1;
	private static final int ARTICLEID = 2;
	private static final String ATTRIBUTE = "att";
	private static final String VALUE = "something";
	private static final Short LANGUAGE = 3;
	private static final Short TYPE = 4;
	
	@Test
	public void ensureToEntityCopiesValues() {
		
		ArticleModel model = new ArticleModel(ID, ARTICLEID, ATTRIBUTE, VALUE, LANGUAGE, TYPE);
		
		Article result = ArticleTransformer.toEntity(model);
		
		assertThat(result.getId(), is(ID));
		assertThat(result.getArticleid(), is(ARTICLEID));
		assertThat(result.getAttribute(), is(ATTRIBUTE));
		assertThat(result.getValue(), is(VALUE));
		assertThat(result.getLanguage(), is(LANGUAGE));
		assertThat(result.getType(), is(TYPE));
	}
	
}
