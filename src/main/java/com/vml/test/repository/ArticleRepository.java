package com.vml.test.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.vml.test.domain.Article;

@Repository
public class ArticleRepository {

	@PersistenceUnit(unitName="vml")
	private EntityManagerFactory emf;

	public Article add(Article data) {

		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(data);

		entityManager.getTransaction().commit();
		entityManager.close();

		return data;
	}
}
