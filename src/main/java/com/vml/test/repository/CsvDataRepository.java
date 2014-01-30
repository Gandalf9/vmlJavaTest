package com.vml.test.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vml.test.domain.Article;

public class CsvDataRepository {

	private EntityManagerFactory entityManagerFactory;

	public CsvDataRepository() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vml");
	}

	public Article createCsvData(Article data) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(data);

		entityManager.getTransaction().commit();
		entityManager.close();

		return data;
	}

}
