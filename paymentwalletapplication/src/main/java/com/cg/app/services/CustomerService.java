package com.cg.app.services;

import java.math.BigDecimal;

import java.util.List;

import com.cg.app.exceptions.CustomerNotFoundException;
import com.cg.app.entity.Customer;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer);
	
	public Customer authenticateCustomer(String mobileNumber, String password)throws CustomerNotFoundException;
	
	public Customer deleteCustomerByMobileNumber(String mobileNo)throws CustomerNotFoundException;
	
	public Customer addAmountToWallet(String mobileNo, BigDecimal amount);
	
	public List<Customer> getAllCustomerList();
	
	public  BigDecimal showBalance(String mobileNo)throws CustomerNotFoundException;
	
	public Customer fundTransfer(String sourceMobileNo,String targetMobileNo, BigDecimal amount);

}
