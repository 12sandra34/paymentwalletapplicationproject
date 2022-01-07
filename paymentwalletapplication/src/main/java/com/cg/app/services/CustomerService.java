package com.cg.app.services;

import com.cg.app.entity.Customer;

public interface CustomerService {
	
	public Customer validateLogin(String mobileNumber,String Password);

}
