package com.cg.app.services;

import java.math.BigDecimal;



import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.exceptions.CustomerNotFoundException;
import com.cg.app.entity.Customer;
import com.cg.app.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;


	@Override
	public Customer registerCustomer(Customer customer) {
	
		//log.info("inside the registerCustomer service method");
		
		Customer savedCustomer= customerRepo.save(customer);
		
		//log.debug("Customer saved with the ID"+savedCustomer.getCustomerId());

		return savedCustomer;
		
	}

	@Override
	public Customer authenticateCustomer(String mobileNumber, String password) throws CustomerNotFoundException {
		
		
		//log.info("authenticating customer....");
		
	 	Customer customer= customerRepo.validateCustomer(mobileNumber, password);
		
	 	if(customer == null)
	 	{
	 		//log.debug("invalid username or password...");
	 		throw new CustomerNotFoundException("Invlaid username or password...");
	 	}else
	 		return customer;
	 	
	 	
	 	
	}

	@Override
	public Customer deleteCustomerByMobileNumber(String mobileNo) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Customer customer=customerRepo.findByMobileNo(mobileNo);
		if(!customer.equals(mobileNo)) {
			
			throw new CustomerNotFoundException("Bank account with mobile number "+mobileNo+"not present");
		}
		else
		return null;
	}

	@Override
	public Customer addAmountToWallet(String mobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomerList() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	@Override
	public BigDecimal showBalance(String mobileNo)throws CustomerNotFoundException {
		//log.info("inside showBalance method");
		
		Customer customer= customerRepo.findByMobileNo(mobileNo);
		
		if(customer == null) {
			
			//log.debug("Customer not found with the mobile number "+mobileNo);
			
			throw new CustomerNotFoundException("Customer does not exist with the give mobile number :"+mobileNo);
			
		}
		else {
			
			//log.info("got the balance from the Customer");
			return customer.getWallet().getBalance();
		}
		
		
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
