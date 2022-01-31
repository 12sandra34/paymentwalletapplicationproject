package com.cg.app.paymentwallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransactionDetailsNotFoundException extends Exception {
	
	
	public TransactionDetailsNotFoundException() {
		
		
	}
	
	
	public TransactionDetailsNotFoundException(String message) {
		
		super(message);
	}

}
