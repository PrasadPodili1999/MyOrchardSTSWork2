package com.mindtree.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.demo.model.Book;
import com.mindtree.demo.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService service;
	
	@RequestMapping(value = "/addBook",method = RequestMethod.POST)
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		Book b=service.addBook(book);
		return new ResponseEntity<Book>(b,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getBook",method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getAllBooks()
	{
		List<Book> books=service.getAllBooks();
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
}
