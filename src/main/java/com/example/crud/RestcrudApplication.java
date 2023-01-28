package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestcrudApplication {

	public static void main(String[] args) {
		System.out.println("here: "+org.hibernate.Version.getVersionString());
		SpringApplication.run(RestcrudApplication.class, args);
	}

}
