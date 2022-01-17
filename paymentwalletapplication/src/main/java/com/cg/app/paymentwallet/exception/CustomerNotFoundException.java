package com.cg.app.paymentwallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public CustomerNotFoundException(String message) {
		
		super(message);
	}

}
