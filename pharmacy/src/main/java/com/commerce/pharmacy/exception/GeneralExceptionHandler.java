package com.commerce.pharmacy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundExeption.class)
	public ResponseEntity<?> customerNotFoundExceptionHandler(ProductNotFoundExeption exeption) {
		return new ResponseEntity<>(exeption.getMessage(), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> generalExceptionHandler(Exception exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
