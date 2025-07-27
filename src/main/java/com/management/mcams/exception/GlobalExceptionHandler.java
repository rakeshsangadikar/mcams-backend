package com.management.mcams.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
		log.error("ResourceNotFoundException: {}", ex.getMessage());
		return buildErrorResponse(ex, HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<Object> handleBadRequest(BadRequestException ex, WebRequest request) {
		log.warn("BadRequestException: {}", ex.getMessage());
		return buildErrorResponse(ex, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		log.error("Unhandled Exception: ", ex);
		return buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	private ResponseEntity<Object> buildErrorResponse(Exception ex, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", status.value());
		body.put("error", status.getReasonPhrase());
		body.put("message", ex.getMessage());
		body.put("path", request.getDescription(false).replace("uri=", ""));
		return new ResponseEntity<>(body, status);
	}

}
