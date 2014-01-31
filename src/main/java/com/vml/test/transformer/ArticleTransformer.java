package com.vml.test.transformer;

import com.vml.test.domain.Article;
import com.vml.test.model.ArticleModel;

//This could probably be replaced by Dozer
public class ArticleTransformer {

	public static Article toEntity(ArticleModel model) {

		return new Article(model.getId(), model.getArticleid(),
				model.getAttribute(), model.getValue(), model.getLanguage(),
				model.getType());
	}
}
