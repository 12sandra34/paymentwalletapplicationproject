package com.cg.app.paymentwallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputException extends Exception {

	public InvalidInputException() {
		
	}
	
   public InvalidInputException(String message) {
	   
	   super(message);
		
	}

	

}
