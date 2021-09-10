package com.microservice.hruser.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		super("User not fount!!");
	}

}
