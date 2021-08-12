package com.mt.onetomanydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class OnetomanydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnetomanydemoApplication.class, args);
		log.info("this is one to many demo project");
	}

}
