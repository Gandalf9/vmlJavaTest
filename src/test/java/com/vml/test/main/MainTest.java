package com.vml.test.main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vml.test.domain.Article;

/**
 * This is the main integration test
 * @author yatinmistry
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-context.xml"})
public class MainTest {

	@PersistenceUnit(unitName="vml")
	private EntityManagerFactory emf;
	
	@Test
	public void testingMain() throws Exception {
		String[] arg = {"src/test/resources/1.csv"};
		Main.main(arg);
		
		EntityManager em = emf.createEntityManager();
		Article article1 = em.find(Article.class, 1);
		Article article2 = em.find(Article.class, 2);
		
		assertThat(article1.getId(), is(1));
		assertThat(article1.getArticleid(), is(1));
		assertThat(article1.getAttribute(), is("definition"));
		assertThat(article1.getValue(), is("xyz"));
		
		assertThat(article2.getId(), is(2));
		assertThat(article2.getArticleid(), is(1));
		assertThat(article2.getAttribute(), is("definition"));
		assertThat(article2.getValue(), is("xyz"));
	}
}
