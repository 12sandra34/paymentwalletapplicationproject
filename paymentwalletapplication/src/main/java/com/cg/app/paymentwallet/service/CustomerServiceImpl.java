package com.cg.app.paymentwallet.service;

import java.math.BigDecimal;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.checkerframework.checker.nullness.Opt;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.app.paymentwallet.entity.Customer;
import com.cg.app.paymentwallet.entity.Wallet;
import com.cg.app.paymentwallet.exception.CustomerNotFoundException;
import com.cg.app.paymentwallet.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	
	
	
    //customer registration
	@Override
	public Customer registerCustomer(Customer customer) {
         
		log.info("inside the registerCustomer service method");
		
		Customer savedCustomer= customerRepo.save(customer);
		
		log.debug("Customer saved with the ID"+savedCustomer.getCustomerId());

		return savedCustomer;
	}
	
	
    //customer login authentication
	@Override
	public Customer authenticateCustomer(String name, String password) throws CustomerNotFoundException {
		
        log.info("authenticating customer....");
		
	 	Customer customer= customerRepo.validateCustomer(name, password);
		
	 	if(customer == null)
	 	{
	 		log.error("invalid username or password");
	 		throw new CustomerNotFoundException("Invlaid username or password...");
	 	}else
	 		
	 		log.info("Welcome user");
	 		return customer;
	}
	
	
    //deleting a customer details
	@Override
	public Customer deleteCustomerById(Integer customerId) throws CustomerNotFoundException {
		
		log.info("inside the delete module");
		Optional<Customer> opt =customerRepo.findById(customerId);
		if(opt.isPresent()) {
			
			Customer customer = opt.get();
			
			customerRepo.delete(customer);
			log.info("deleted the details");
			return customer;
			
		}
		
		else {
			 log.error("customer doesnot exist");
			throw new CustomerNotFoundException("customer does not exist with customerId:"+customerId);
		}
	}
	
	
    
	//adding amount to wallet
	@Override
	@Transactional
	public Customer addAmountToWallet(String mobileNO , BigDecimal amount) throws CustomerNotFoundException {
		
		Customer customer= customerRepo.findByMobileNo(mobileNO);
		
			if(customer==null) {
			
				throw new CustomerNotFoundException("customer does not exist");
			
			}
			else {
				
				customer.getWallet().getBalance().add(amount);
				return customer;
			}
			
			
		
		
		
		
		
		
		
	}
	
    
	//getting all customer list
	@Override
	public List<Customer> getAllCustomerList() {
		log.info("All customer details are here");
		return customerRepo.findAll();
	}
	
	
	
	
    //view balance
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

	
	
    //fund transferring
	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws CustomerNotFoundException {
		
		
			
			
		
		
		 return null;
	}

}
