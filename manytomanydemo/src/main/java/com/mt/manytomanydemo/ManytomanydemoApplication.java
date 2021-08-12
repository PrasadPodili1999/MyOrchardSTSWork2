package com.mt.manytomanydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication
public class ManytomanydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManytomanydemoApplication.class, args);
		
		log.info("this is many to many demo project");
	}

}
