package com.vml.test.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vml.test.domain.Article;
import com.vml.test.exception.VmlApplicationException;
import com.vml.test.repository.CsvDataRepository;

@Service
public class ArticleService {
	
	private Logger logger = LoggerFactory.getLogger(ArticleService.class);
	
	private CsvDataRepository csvDataRepository;
	
	private ArticleReader articleReader;
	
	@Autowired
	public void setCsvDataRepository(CsvDataRepository csvDataRepository) {
		this.csvDataRepository = csvDataRepository;
	}

	@Autowired
	public void setArticleReader(ArticleReader articleReader) {
		this.articleReader = articleReader;
	}
	
	public void loadFileIntoApplication(String fileLocation) throws VmlApplicationException {

		logger.info(String.format("Going to upload file %s", fileLocation));
		
		List<Article> articles = articleReader.readCSVFile(fileLocation);
		
		transformArticles(articles);
		
		for (Article article : articles) {
			csvDataRepository.createCsvData(article);
		}
	}
	
	private void transformArticles(List<Article> articles) {
		//TODO: Need to implement this method
	}

}
