package com.cg.app.paymentwallet.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.app.paymentwallet.entity.Customer;
import com.cg.app.paymentwallet.exception.CustomerNotFoundException;
import com.cg.app.paymentwallet.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer registerCustomer(Customer customer) {
         
		log.info("inside the registerCustomer service method");
		
		Customer savedCustomer= customerRepo.save(customer);
		
		log.debug("Customer saved with the ID"+savedCustomer.getCustomerId());

		return savedCustomer;
	}

	@Override
	public Customer authenticateCustomer(String mobileNumber, String password) throws CustomerNotFoundException {
		
        log.info("authenticating customer....");
		
	 	Customer customer= customerRepo.validateCustomer(mobileNumber, password);
		
	 	if(customer == null)
	 	{
	 		log.debug("invalid username or password...");
	 		throw new CustomerNotFoundException("Invlaid username or password...");
	 	}else
	 		return customer;
	}

	@Override
	public Customer deleteCustomerByMobileNumber(String mobileNo) throws CustomerNotFoundException {
		
		Customer customer =customerRepo.deleteByMobileNo(mobileNo);
		if(customer==null) {
			throw new CustomerNotFoundException("Customer does not exist");
			
			
		}
		
		else {
			 
			return customer;
			
			
		}
	}
	
	

	@Override
	public Customer addAmountToWallet(String mobileNo, BigDecimal amount) {
		return null;
		
	}
	

	@Override
	public List<Customer> getAllCustomerList() {
		return customerRepo.findAll();
	}
	
	
	
	

	@Override
	public BigDecimal showBalance(String mobileNo) throws CustomerNotFoundException {
		
		
       log.info("inside showBalance method");
		
		Customer customer= customerRepo.findByMobileNo(mobileNo);
		
		if(customer == null) {
			
			log.debug("Customer not found with the mobile number "+mobileNo);
			
			throw new CustomerNotFoundException("Customer does not exist with the give mobile number :"+mobileNo);
			
		}
		else {
			
			log.info("got the balance from the Customer");
			return customer.getWallet().getBalance();
		}
		
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
