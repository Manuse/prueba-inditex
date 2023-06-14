package com.pruebainditex.comercioapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pruebainditex.comercio.dto.ErrorDTO;
import com.pruebainditex.comercioapi.exception.NotFoundException;

@RestControllerAdvice
public class ExceptionController {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ErrorDTO handleNotFoundException(NotFoundException ex) {
		return new ErrorDTO()
				.message(ex.getMessage())
				.code(HttpStatus.NOT_FOUND.value());
	}
	
}
