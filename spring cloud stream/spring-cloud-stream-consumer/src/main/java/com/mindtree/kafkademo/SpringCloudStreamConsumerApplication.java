package com.mindtree.kafkademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.mindtree.kafkademo.model.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringCloudStreamConsumerApplication {

	//private Logger logger = LoggerFactory.getLogger(SpringCloudStreamConsumerApplication.class);
	@StreamListener("input")
	public void consumeMessage(Book book)
	{
		log.info("consume payload : "+book);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamConsumerApplication.class, args);
	}

}
