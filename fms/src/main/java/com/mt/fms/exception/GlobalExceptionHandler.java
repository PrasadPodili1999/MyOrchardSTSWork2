package com.mt.fms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity<?> invalidNameExceptionHandling(InvalidNameException exception, WebRequest request)
	{
		ErrorMessage msg=new ErrorMessage(exception.getMessage());
		log.error("Invalid Name Entered");
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<?> invalidDataExceptionHandling(InvalidDataException exception, WebRequest request)
	{
		ErrorMessage msg=new ErrorMessage(exception.getMessage());
		log.error("Invalid Data Entered");
		return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request)
	{
		ErrorMessage msg=new ErrorMessage();
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	}
}
