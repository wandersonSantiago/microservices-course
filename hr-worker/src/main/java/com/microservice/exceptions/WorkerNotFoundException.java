package com.microservice.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WorkerNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public WorkerNotFoundException() {
		super("Worker not fount!!");
	}

}
