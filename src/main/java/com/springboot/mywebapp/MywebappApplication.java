package com.springboot.mywebapp;

import com.springboot.mywebapp.modal.Student;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MywebappApplication {


	public static Logger logger = LoggerFactory.getLogger(MywebappApplication.class);


	@PostConstruct
	public void init() {
		logger.info("MywebappApplication Started...");
	}

	public static void main(String[] args) {

		logger.info("MywebappApplication Executed...");
		SpringApplication.run(MywebappApplication.class, args);

		Student s = Student.builder().id(101).name("parul").build();
		System.out.println(s.toString());
	}

}
