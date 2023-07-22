 package com.onesoft.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptions {
	@ExceptionHandler(EmployeeNameException.class)
	public ResponseEntity<Object> NameNotFoundExceptionHandling(EmployeeNameException a) {
		return new ResponseEntity<>(a.getMessage(), HttpStatus.NOT_FOUND);
	}

}
