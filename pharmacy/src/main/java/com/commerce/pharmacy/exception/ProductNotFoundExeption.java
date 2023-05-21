package com.commerce.pharmacy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundExeption extends RuntimeException {
	public ProductNotFoundExeption(String message) {

		super(message);
	}

}
