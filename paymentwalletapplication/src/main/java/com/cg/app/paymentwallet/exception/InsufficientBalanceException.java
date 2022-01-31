package com.cg.app.paymentwallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsufficientBalanceException extends Exception {

	public InsufficientBalanceException() {
		
	}

	public InsufficientBalanceException(String message) {
		super(message);
	}
	
	
	

}
