package com.vml.test.service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.vml.test.domain.Article;
import com.vml.test.supercsv.ParseShort;

public class ArticleReader {
	
	private static Logger logger = LoggerFactory.getLogger(ArticleReader.class);
	
	private static final String CSV_FILENAME = "src/test/resources/test.csv";

	private static CellProcessor[] getProcessors() {

		final CellProcessor[] processors = new CellProcessor[] {
				new UniqueHashCode(new ParseInt()), // id
				new Optional(new ParseInt()), // ARTICLEID
				new Optional(), // ATTRIBUTE
				new Optional(), // VALUE
				new Optional(new ParseShort()), // LANGUAGE
				new Optional(new ParseShort()) // TYPE
		};

		return processors;
	}
	
	public List<Article> readCSVFile() throws Exception {
		
		ICsvBeanReader beanReader = null;
		try {
			beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE);

			final String[] headers = beanReader.getHeader(true);
			
			for (int i = 0; i < headers.length; i++) {
				headers[i] = headers[i].toLowerCase();
			}
			
			final CellProcessor[] processors = getProcessors();

			List<Article> articles = new ArrayList<Article>();
			Article article = null;
			
			//TODO: Bug If first element fails, then will not process the file
			do {
				try {
					article = beanReader.read(Article.class, headers, processors);
					if (article != null) articles.add(article);
					
				} catch (SuperCsvCellProcessorException e) {
					logger.warn(e.getMessage());
				}
						
			} while (article != null);
				
			return articles;

		} finally {
			if (beanReader != null) {
				beanReader.close();
			}
		}
	}
}
