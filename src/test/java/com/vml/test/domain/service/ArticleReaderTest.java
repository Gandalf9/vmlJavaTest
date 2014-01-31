package com.vml.test.domain.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.vml.test.exception.VmlApplicationException;
import com.vml.test.model.ArticleModel;
import com.vml.test.service.ArticleReader;

public class ArticleReaderTest {
	
	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test
	public void happyPath() throws Exception {
		ArticleReader reader = new ArticleReader();
		
		List<ArticleModel> readCSVFile = reader.readCSVFile("src/test/resources/1.csv");
		
		assertThat(readCSVFile, hasSize(2));
		
	}
	
	@Test
	public void ensureContinuationIfFirstRowErrors() throws Exception {
		ArticleReader reader = new ArticleReader();
		
		List<ArticleModel> readCSVFile = reader.readCSVFile("src/test/resources/2.csv");
		
		assertThat(readCSVFile, hasSize(3));
		//TODO: Need to check that the errored element not got into array
	}
	
	@Test
	public void throwFileNotFoundException() throws Exception {
		ArticleReader reader = new ArticleReader();
		expected.expect(VmlApplicationException.class);
		expected.expectMessage("File Location invalid {xyz}");
		
		List<ArticleModel> readCSVFile = reader.readCSVFile("xyz");
		
		assertThat(readCSVFile, empty());
	}
}
