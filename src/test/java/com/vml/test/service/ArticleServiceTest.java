package com.vml.test.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.ImmutableList;
import com.vml.test.domain.Article;
import com.vml.test.model.ArticleModel;
import com.vml.test.repository.ArticleRepository;


/**
 * 
 * Have used both a mockist and classist style to testing through out this application, to demonstrate both
 * Here I'm using mockist style
 * @author yatinmistry
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceTest {
	
	@Mock
	private ArticleRepository csvDataRepositoryMock;
	
	@Mock
	private ArticleReader articleReaderMock;
	
	@InjectMocks
	private ArticleService articleService = new ArticleService();
	
	private static final String FILE_LOCATION = "location";

	@Test
	public void ensureCorrectComponentsCalled() throws Exception{
		
		List<ArticleModel> models = ImmutableList.of(new ArticleModel(), new ArticleModel());
		
		when(articleReaderMock.readCSVFile(FILE_LOCATION)).thenReturn(models);
				
		articleService.loadDataFromFile(FILE_LOCATION);
		
		//TODO: Be more specific with the articles and ensure the models gone in have the same properties
		//as the articles coming out. This is actually tested in the ArticleTransformerTest
		verify(csvDataRepositoryMock, times(2)).add(any(Article.class));
	}
}
