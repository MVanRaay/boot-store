package com.martin.bootstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootStoreApplication.class, args);
		System.out.println("Server listening on: http://localhost:8080/");
	}

}
