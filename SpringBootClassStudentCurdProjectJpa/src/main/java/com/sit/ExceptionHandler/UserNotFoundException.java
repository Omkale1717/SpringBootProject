package com.sit.ExceptionHandler;

public class UserNotFoundException   extends RuntimeException{
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
	
	

}
