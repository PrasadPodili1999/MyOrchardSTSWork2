package com.mindtree.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kafkademo.model.Book;

@RestController
public class BookController {

	@Autowired
	private MessageChannel output;
	
	@RequestMapping(value = "/publish",method = RequestMethod.POST)
	public Book publishEvent(@RequestBody Book book)
	{
		output.send(MessageBuilder.withPayload(book).build());
		return book;
	}
}
