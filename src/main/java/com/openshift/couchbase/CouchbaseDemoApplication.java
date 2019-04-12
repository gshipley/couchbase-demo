package com.openshift.couchbase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class CouchbaseDemoApplication {

	@Autowired
	private static Environment environment;

	public static void main(String[] args) {

		SpringApplication.run(CouchbaseDemoApplication.class, args);

	}
}
