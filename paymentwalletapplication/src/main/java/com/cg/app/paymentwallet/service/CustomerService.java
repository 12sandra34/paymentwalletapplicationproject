package com.cg.app.paymentwallet.service;

import java.math.BigDecimal;
import java.util.List;
import com.cg.app.paymentwallet.entity.Customer;
import com.cg.app.paymentwallet.exception.CustomerException;
import com.cg.app.paymentwallet.exception.InsufficientBalanceException;
import com.cg.app.paymentwallet.exception.InvalidInputException;






public interface CustomerService {
	
    public Customer registerCustomer(Customer customer)throws CustomerException;
    
	public Customer authenticateCustomer(String mobileNumber, String password)throws CustomerException;
	
	public Customer deleteCustomerById(Integer customerId)throws CustomerException;
	
	public List<Customer> getAllCustomerList();
	
	public  BigDecimal showBalance(String mobileNo)throws CustomerException;
	
	public Customer addAmountToWallet(String mobileNo,BigDecimal amount) throws CustomerException;
	
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws CustomerException,InvalidInputException,InsufficientBalanceException;
	
	public Customer withdrawAmount(String mobileNo, BigDecimal amount)throws CustomerException;
	
	
}
