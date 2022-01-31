package com.cg.app.paymentwallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MobileNumberNotRegistered  extends Exception{

	public MobileNumberNotRegistered() {
		
		
	}
	
	
public MobileNumberNotRegistered(String message) {
		
	super(message);
		
	}
	
	
	
	
	

}
