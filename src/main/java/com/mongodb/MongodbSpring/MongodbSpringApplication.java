package com.mongodb.MongodbSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories
public class MongodbSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbSpringApplication.class, args);
	}

}
