package com.sit.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomExceptionHandler {
	@ExceptionHandler()
	public ResponseEntity<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException 
			ex)
	{
		Map <String ,String> errors=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error->{
		
			String fildName=((FieldError) error).getField();
			 String errorMessage = error.getDefaultMessage();
	            errors.put(fildName, errorMessage);

			
			
		});
		  return ResponseEntity.badRequest().body(errors);
		
	}
	   @ExceptionHandler(InvalidPasswordException.class)
	    public ResponseEntity<String> handleInvalidPasswordException(InvalidPasswordException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	
	
	
	

}
