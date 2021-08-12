package com.mindtree.schedulerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.mindtree.schedulerdemo.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableScheduling
@EnableBinding(Sink.class)
public class CloudStreamSchedulerConsumerApplication {

	@StreamListener("input")
	public void consumeMessage(User user)
	{
		log.info("consume payload : "+user);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CloudStreamSchedulerConsumerApplication.class, args);
	}

}
