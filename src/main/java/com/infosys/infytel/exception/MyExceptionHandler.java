package com.infosys.infytel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(value = MyExceptionHandler.class)

	public ResponseEntity<Object> exception(LimitIncreasedException e) {
		
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = WrongCredentialException.class)

	public ResponseEntity<Object> exception(WrongCredentialException e) {
		
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)

	public ResponseEntity<Object> exception(UserNotFoundException e) {
		
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	

}
