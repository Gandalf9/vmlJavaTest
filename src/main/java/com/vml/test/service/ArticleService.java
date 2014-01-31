package com.vml.test.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.vml.test.domain.Article;
import com.vml.test.exception.VmlApplicationException;
import com.vml.test.model.ArticleModel;
import com.vml.test.repository.ArticleRepository;
import com.vml.test.transformer.ArticleTransformer;

@Service
public class ArticleService {
	
	private Logger logger = LoggerFactory.getLogger(ArticleService.class);
	
	private ArticleRepository csvDataRepository;
	
	private ArticleReader articleReader;
	
	@Autowired
	public void setCsvDataRepository(ArticleRepository csvDataRepository) {
		this.csvDataRepository = csvDataRepository;
	}

	@Autowired
	public void setArticleReader(ArticleReader articleReader) {
		this.articleReader = articleReader;
	}
	
	public void loadDataFromFile(String fileLocation) throws VmlApplicationException {

		logger.info(String.format("Going to upload file %s", fileLocation));
		
		List<ArticleModel> models = articleReader.readCSVFile(fileLocation);
		
		List<Article> articles = transformArticles(models);
		
		for (Article article : articles) {
			csvDataRepository.add(article);
		}
	}
	
	
	private List<Article> transformArticles(List<ArticleModel> articles) {
		
		//TODO: Any validation will go here.
		
		//I know this is an over kill for use of Guava transform. Easier just to use a for loop (does same
		//thing under the covers). Just wanted to show use of Guava.
		return Lists.newArrayList(Iterables.transform(articles, new Function<ArticleModel, Article>() {

			@Override
			public Article apply(ArticleModel model) {
				return ArticleTransformer.toEntity(model);
			}
		}));
	}
}
