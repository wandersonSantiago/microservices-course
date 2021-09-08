package com.microservice.exceptions;

import java.time.OffsetDateTime;
import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(WorkerNotFoundException.class)
	public ResponseEntity<?> handleExceptionEntity(WorkerNotFoundException e, WebRequest request) {
		var map = new HashMap<>();
		map.put("status", "404");
		map.put("message", e.getMessage());
		map.put("timestamp", OffsetDateTime.now());
		return handleExceptionInternal(e, map, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
