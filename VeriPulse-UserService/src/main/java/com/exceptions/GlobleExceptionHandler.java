package com.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dto.ErrorResponse;

@RestControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> handleValidationException(MethodArgumentNotValidException ex) {

		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> error.getField() + " " + error.getDefaultMessage()).collect(Collectors.toList());

		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(ResourceFoundException.class)
	public ResponseEntity<ErrorResponse> errorResponseHandling(ResourceFoundException re) {

		ErrorResponse er = new ErrorResponse(HttpStatus.CONFLICT.value(), "Conflict", re.getMessage());

		return new ResponseEntity<>(er, HttpStatus.CONFLICT);

	}

}
