package com.yash.EmployeeMgmt.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public String resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
			return ex.getMessage();
		}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgumentNotvalidException(MethodArgumentNotValidException ex) {
		Map<String,String>map=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(errors->{
			String field = ((FieldError)errors).getField();
			String message = errors.getDefaultMessage();
			map.put(field, message);
		});
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
}
