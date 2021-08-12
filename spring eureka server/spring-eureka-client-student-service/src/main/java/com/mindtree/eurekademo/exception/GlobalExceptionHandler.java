package com.mindtree.eurekademo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	// to handle specific exception
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<?> studentNotFoundHandling(StudentNotFoundException exception, WebRequest request) {
		ErrorMessage errorMsg = new ErrorMessage(new Date(), exception.getMessage(), request.getDescription(true));
		return new ResponseEntity<>(errorMsg, HttpStatus.NOT_FOUND);
	}

	// to handle specific exception
	@ExceptionHandler(InvalidSchoolNameException.class)
	public ResponseEntity<?> invalidSchoolNameHandling(InvalidSchoolNameException exception, WebRequest request) {
		ErrorMessage errorMsg = new ErrorMessage(new Date(), exception.getMessage(), request.getDescription(true));
		return new ResponseEntity<>(errorMsg, HttpStatus.NOT_FOUND);
	}

	// to handle specific exception
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<?> invalidDataHandling(InvalidDataException exception, WebRequest request) {
		ErrorMessage errorMsg = new ErrorMessage(new Date(), exception.getMessage(), request.getDescription(true));
		return new ResponseEntity<>(errorMsg, HttpStatus.NOT_FOUND);
	}

	// to handle global exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionsHandling(Exception exception, WebRequest request) {
		ErrorMessage errorMsg = new ErrorMessage(new Date(), exception.getMessage(), request.getDescription(true));
		return new ResponseEntity<>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
