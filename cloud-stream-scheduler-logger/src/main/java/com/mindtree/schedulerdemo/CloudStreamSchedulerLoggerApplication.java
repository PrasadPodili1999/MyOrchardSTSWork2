package com.mindtree.schedulerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableBinding(Source.class)
@SpringBootApplication
public class CloudStreamSchedulerLoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamSchedulerLoggerApplication.class, args);
	}

}
