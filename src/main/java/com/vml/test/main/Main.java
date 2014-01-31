package com.vml.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vml.test.service.ArticleService;

public class Main {

	public static void main(String[] args) throws Exception {
		
		if (args.length < 1 || args.length > 1 || args[0] == null) {
			throw new IllegalArgumentException(String.format("Incorrect number of parameters {%d}\nShould use the format: java com.vml.test.main.Main [fileLocation]", args.length));
		}
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
		ArticleService articleService = (ArticleService) ctx.getBean("articleService");
		articleService.loadDataFromFile(args[0]);
	}
}
