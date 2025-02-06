package com.sit.ExceptionHandler;

public class InvalidPasswordException extends RuntimeException {
	
	public InvalidPasswordException(String msg) {
		super(msg);
	}

}
