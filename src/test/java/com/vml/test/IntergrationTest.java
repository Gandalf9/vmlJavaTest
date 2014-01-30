package com.vml.test;

import com.vml.test.domain.Article;
import com.vml.test.repository.CsvDataRepository;

public class IntergrationTest {

	public static void main(String[] args) {
		
		Article data = new Article(1, "attibute.yatin", "value.yatin", 1, 1);
		
		CsvDataRepository repo = new CsvDataRepository();
		repo.createCsvData(data);
	}
}
