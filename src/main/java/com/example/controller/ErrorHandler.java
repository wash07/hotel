package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorHandler {
	

	private Logger log = LoggerFactory.getLogger(ErrorHandler.class);

	@ExceptionHandler(value = {RuntimeException.class})
	public ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
		log.error("[ERROR] Exception: " + ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
	}
}