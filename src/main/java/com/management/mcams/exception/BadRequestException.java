package com.management.mcams.exception;

public class BadRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 2854598299135104618L;

	public BadRequestException(String message) {
        super(message);
    }
}

