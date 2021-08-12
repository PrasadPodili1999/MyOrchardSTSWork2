package com.mt.manytomanydemo.exceptionhandler;

public class StudentCourseNotFoundException extends Exception{

	public StudentCourseNotFoundException() {
		super();
	}
	public StudentCourseNotFoundException(String msg) {
		super(msg);
	}
}
