package com.management.mcams.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 6156688393197218853L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}

