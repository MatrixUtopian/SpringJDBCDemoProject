package com.prakhar.SpringJDBCDemo;

import com.prakhar.SpringJDBCDemo.model.Degen;
import com.prakhar.SpringJDBCDemo.repo.DegenRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);

		Degen degen1 = context.getBean(Degen.class);
		degen1.setId(1);
		degen1.setName("Prakhar");
		degen1.setTech("Java");

		DegenRepo repo = context.getBean(DegenRepo.class);
		repo.save(degen1);

		System.out.println(repo.findAll());

	}
}
