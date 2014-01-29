package com.vml.test;

import com.vml.test.domain.CsvData;
import com.vml.test.repository.CsvDataRepository;

public class IntergrationTest {

	public static void main(String[] args) {
		
		CsvData data = new CsvData(1, "attibute.yatin", "value.yatin", 1, 1);
		
		CsvDataRepository repo = new CsvDataRepository();
		repo.createCsvData(data);
	}
}
