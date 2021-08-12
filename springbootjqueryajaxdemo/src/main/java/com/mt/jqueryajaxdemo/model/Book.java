package com.mt.jqueryajaxdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {

	private int bookId;
	private String bookName;
	private String author;
	public Book(int bookId, String bookName, String author) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
	}
	public Book() {
		super();
	}
	
}
