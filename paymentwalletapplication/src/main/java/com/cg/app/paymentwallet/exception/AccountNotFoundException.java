package com.cg.app.paymentwallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountNotFoundException extends Exception {
	
	public AccountNotFoundException() {
		
	}
	
	
	public AccountNotFoundException(String message) {
		
		super(message);
	}

}
