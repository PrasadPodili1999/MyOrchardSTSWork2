package com.mt.onetomanydemo.exceptionhandler;

public class QuestionNotFoundException extends Exception{

	public QuestionNotFoundException( )
	{
		super();
	}
	public QuestionNotFoundException(String msg)
	{
		super(msg);
	}
	public QuestionNotFoundException(String msg,Throwable t)
	{
		super(msg,t);
	}
	public QuestionNotFoundException(Throwable t)
	{
		super(t);
	}
}
