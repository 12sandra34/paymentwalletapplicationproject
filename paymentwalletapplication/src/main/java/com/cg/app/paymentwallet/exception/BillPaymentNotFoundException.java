package com.cg.app.paymentwallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BillPaymentNotFoundException extends Exception {
	
	
	public BillPaymentNotFoundException() {
		
	}
	
	public BillPaymentNotFoundException(String message) {
		
		super(message);
	}

}
