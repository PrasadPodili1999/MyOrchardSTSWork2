package com.mt.ims.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StockNotFoundException.class)
	public ResponseEntity<?> stockNotFoundExceptionHandling(StockNotFoundException exception, WebRequest request)
	{
		ErrorMessage msg=new ErrorMessage(exception.getMessage());
		log.error("Invalid Stock Name Entered");
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidOrderException.class)
	public ResponseEntity<?> invalidOrderExceptionHandling(InvalidOrderException exception, WebRequest request)
	{
		ErrorMessage msg=new ErrorMessage(exception.getMessage());
		log.error("Invalid order Name Entered");
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(QuantityNotAvailableException.class)
	public ResponseEntity<?> quantityNotAvailableExceptionHandling(QuantityNotAvailableException exception, WebRequest request)
	{
		ErrorMessage msg=new ErrorMessage(exception.getMessage());
		log.error("Invalid Stock quantity Name Entered");
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request)
	{
		ErrorMessage msg=new ErrorMessage();
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	}
}
