package com.mt.manytomanydemo.exceptionhandler;

public class StudentNotFoundException extends Exception{

	public StudentNotFoundException() {
		super();
	}
	public StudentNotFoundException(String msg) {
		super(msg);
	}
	
}
