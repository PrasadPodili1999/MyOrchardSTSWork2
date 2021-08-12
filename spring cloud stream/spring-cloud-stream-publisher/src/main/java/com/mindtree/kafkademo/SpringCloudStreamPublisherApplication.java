package com.mindtree.kafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.EnableMBeanExport;

@SpringBootApplication
@EnableBinding(Source.class)
public class SpringCloudStreamPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamPublisherApplication.class, args);
	}
}
