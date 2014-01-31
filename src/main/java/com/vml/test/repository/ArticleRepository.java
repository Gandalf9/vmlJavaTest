package com.vml.test.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vml.test.domain.Article;

@Repository
public class ArticleRepository {

	@PersistenceContext
    protected EntityManager entityManager;

	@Transactional
	public Article add(Article data) {
		entityManager.persist(data);
		return data;
	}
}
