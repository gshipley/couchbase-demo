package com.javacouch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class JavaCouchApplication {

	@Autowired
	private static Environment environment;

	public static void main(String[] args) {

		SpringApplication.run(JavaCouchApplication.class, args);

	}
}
