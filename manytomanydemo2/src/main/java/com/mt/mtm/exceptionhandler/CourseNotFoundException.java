package com.mt.mtm.exceptionhandler;

public class CourseNotFoundException extends Exception{

	public CourseNotFoundException()
	{
		super();
	}
	public CourseNotFoundException(String msg)
	{
		super(msg);
	}
}
