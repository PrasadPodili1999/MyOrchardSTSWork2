package com.mt.springdatajpa.exceptionhandler;

public class StudentNotFound extends Exception{

	public StudentNotFound(String msg)
	{
		super(msg);
	}
	public StudentNotFound()
	{
		
	}
}
