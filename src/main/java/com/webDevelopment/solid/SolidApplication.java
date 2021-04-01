package com.webDevelopment.solid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolidApplication {

	public static final Logger LOGGER = LoggerFactory.getLogger(SolidApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SolidApplication.class, args);
	}

}
