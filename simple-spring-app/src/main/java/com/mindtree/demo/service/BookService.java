package com.mindtree.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.demo.model.Book;
import com.mindtree.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repo;
	
	public Book addBook(Book book)
	{
		return repo.save(book);
	}
	
	public List<Book> getAllBooks()
	{
		return (List<Book>)repo.findAll();
	}
}
