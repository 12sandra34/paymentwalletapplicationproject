package com.cg.app.paymentwallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WalletException extends Exception {

	public WalletException() {
		super();
		
	}

	public WalletException(String message) {
		super(message);
		
	}
	
	
	

}
