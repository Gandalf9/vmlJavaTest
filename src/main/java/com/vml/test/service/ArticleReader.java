package com.vml.test.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvException;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.vml.test.domain.Article;
import com.vml.test.exception.VmlApplicationException;
import com.vml.test.model.ArticleModel;
import com.vml.test.supercsv.ParseShort;

//TODO: This class technically does not need to be a spring component.
@Component
public class ArticleReader {
	
	private static Logger logger = LoggerFactory.getLogger(ArticleReader.class);
	
	public ArticleReader() {
	}
	
	private static CellProcessor[] getProcessors() {

		final CellProcessor[] processors = new CellProcessor[] {
				new UniqueHashCode(new ParseInt()), // ID
				new Optional(new ParseInt()), // ARTICLEID
				new Optional(), // ATTRIBUTE
				new Optional(), // VALUE
				new Optional(new ParseShort()), // LANGUAGE
				new Optional(new ParseShort()) // TYPE
		};

		return processors;
	}
	
	public List<ArticleModel> readCSVFile(String fileLocation) throws VmlApplicationException {
		
		try (ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(fileLocation), CsvPreference.STANDARD_PREFERENCE) ) {

			final String[] headers = beanReader.getHeader(true);
			
			for (int i = 0; i < headers.length; i++) {
				headers[i] = headers[i].toLowerCase();
			}
			
			final CellProcessor[] processors = getProcessors();

			List<ArticleModel> articles = new ArrayList<>();
			ArticleModel article = null;
			boolean finished = false;
			
			while(!finished) {
				try {
					article = beanReader.read(ArticleModel.class, headers, processors);
					if (article != null) {
						articles.add(article);
					} else {
						finished = true;
					}
				} catch (Exception e) {
					logger.warn(e.getMessage());
				}
			}
				
			return articles;
			
		} catch(SuperCsvException e) {
			throw new VmlApplicationException(String.format("File Location invalid {%s}", fileLocation), e);
		} catch(FileNotFoundException e) {
			throw new VmlApplicationException(String.format("File Location invalid {%s}", fileLocation), e);
		} catch(IOException e) {
			throw new VmlApplicationException("Error loading the headers", e);
		} 
	}
}
