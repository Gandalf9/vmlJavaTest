package com.vml.test.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.vml.test.domain.Article;


/**
 * This is a semi functional test to ensure correct data goes into the database
 * @author yatinmistry
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-context.xml"})
@Transactional
@Ignore  //TODO: renable ignored repo test
public class ArticleRespositoryTest {

	private static final int ID = 1;
	private static final int ARTICLEID = 2;
	private static final String ATTRIBUTE = "att";
	private static final String VALUE = "something";
	private static final Short LANGUAGE = 3;
	private static final Short TYPE = 4;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Test
	@Rollback(true)
	public void ensureDataSavedIntoDatabase() {
		Article article = new Article(ID, ARTICLEID, ATTRIBUTE, VALUE, LANGUAGE, TYPE);
		articleRepository.add(article);
		
		//Ensure Data has gone into database
		Article result = em.find(Article.class, ID);
		
		//Check Results
		assertThat(result.getId(), is(ID));
		assertThat(result.getArticleid(), is(ARTICLEID));
		assertThat(result.getAttribute(), is(ATTRIBUTE));
		assertThat(result.getValue(), is(VALUE));
		assertThat(result.getLanguage(), is(LANGUAGE));
		assertThat(result.getType(), is(TYPE));
	}
	
}
