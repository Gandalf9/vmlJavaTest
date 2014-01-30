package com.vml.test.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vml.test.domain.Article;
import com.vml.test.repository.CsvDataRepository;
import com.vml.test.service.ArticleReader;

public class Main {

	private static Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) throws Exception {
		
		logger.debug("Going to kick off the application");
		ArticleReader articleReader = new ArticleReader();
		CsvDataRepository repo = new CsvDataRepository();
		
		List<Article> articles = articleReader.readCSVFile();
		
		logger.debug("Grabbed data from the database");
		
		for (Article article : articles) {
			repo.createCsvData(article);
		}
	}
}
