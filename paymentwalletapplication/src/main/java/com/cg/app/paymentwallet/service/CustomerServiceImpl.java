package com.cg.app.paymentwallet.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.app.paymentwallet.entity.Customer;
import com.cg.app.paymentwallet.entity.Wallet;
import com.cg.app.paymentwallet.exception.CustomerException;
import com.cg.app.paymentwallet.exception.InsufficientBalanceException;
import com.cg.app.paymentwallet.exception.InvalidInputException;
import com.cg.app.paymentwallet.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
   
	
    //customer registration
	@Override
	public Customer registerCustomer(Customer customer)throws CustomerException {
         
		log.info("inside the registerCustomer service method");
		
		
		
		
		
		Customer savedCustomer= customerRepo.save(customer);
		
		
		log.info("Customer saved with the ID " +savedCustomer.getCustomerId());

		return savedCustomer;
	
	}
	
	
    //customer login authentication
	@Override
	public Customer authenticateCustomer(String name, String password) throws CustomerException {
		
        log.info("authenticating customer....");
		
	 	Customer customer= customerRepo.validateCustomer(name, password);
		
	 	    if(customer == null)
	 	    {
	 		   log.error("invalid username or password");
	 		   throw new CustomerException("Invlaid username or password...");
	 	    }
	 	
	 	    else
	 		
	 		  log.info("Welcome user");
	 		  return customer;
	
	}

	
	
    //deleting a customer details
	@Override
	public Customer deleteCustomerById(Integer customerId) throws CustomerException {
		
		log.info("inside the delete module");
		Optional<Customer> opt =customerRepo.findById(customerId);
		if(opt.isPresent()) {
			
			Customer customer = opt.get();
			
			customerRepo.delete(customer);
			log.info("deleted the details");
			return customer ;
			
		}
		
		else {
			 log.error("customer doesnot exist");
			throw new CustomerException("customer does not exist with customerId:"+customerId);
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
	public BigDecimal showBalance(String mobileNo) throws CustomerException {
		
		
       log.info("inside showBalance method");
		
		Customer customer= customerRepo.findByMobileNo(mobileNo);
		
		if(customer == null) {
			
			log.error("Customer not found with the mobile number "+mobileNo);
			
			throw new CustomerException("Customer does not exist with the give mobile number :"+mobileNo);
			
		}
		else {
			
			log.info("got the balance from the Customer");
			return  customer.getWallet().getBalance();
		}
		
	}


	

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount)
			throws CustomerException,InvalidInputException,InsufficientBalanceException
			 {
		
		if(amount.compareTo(new BigDecimal("0.00")) ==0)
		{
			log.error("amount cannot be zero");
			throw new InvalidInputException("You cannot transfer Zero balance");
			
		} 
		if(amount.compareTo(new BigDecimal("0.00")) <0)
		{
			log.error("amount cannot be zero");
			throw new InvalidInputException("amount cannot be negative");
			
		} 
		
		
		Customer customer1=customerRepo.findByMobileNo(sourceMobileNo);
		Customer customer2=customerRepo.findByMobileNo(targetMobileNo);
		
		 if(customer1==null && customer2==null)
			 
			 
          	  throw new CustomerException("Source mobile Number and target mobile number is not registered");
          
		 else if(customer2==null)
			 
 	          throw new CustomerException("Target mobile Number is not registered");
          
		 else if(customer1==null)
			 
 	          throw new CustomerException("Source mobile Number is not registered");
 
		
		 else
         {
	         if(sourceMobileNo.equals(targetMobileNo))
	          {
	        throw new InvalidInputException("Source mobile number and target mobile number cannot be same");
	            }
	         
	         
             BigDecimal balance=customer1.getWallet().getBalance();
	         Integer walletId=customer1.getWallet().getWalletId();
             balance = balance.subtract(amount);
    
         if(balance.compareTo(new BigDecimal("0.00")) <0)
          {
	     throw new InsufficientBalanceException("Insufficient balance in source registered mobile number");
          }
              Wallet wallet =new Wallet(walletId,balance);
              customer1.setWallet(wallet);
              
              BigDecimal balance2=customer2.getWallet().getBalance();
              Integer walletId2=customer2.getWallet().getWalletId();
              balance2=balance2.add(amount);
		      Wallet wallet2=new Wallet(walletId2,balance2);
              customer2.setWallet(wallet2);

	          customerRepo.save(customer1);
	          customerRepo.save(customer2);
              log.info("transfered " +amount+ " from " +sourceMobileNo+ " to " +targetMobileNo+ " successfully ");
              log.info("current balance:" +balance);
              return customer1;
          }
	
			 }


	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) throws CustomerException{
		
		Customer customer = customerRepo.findByMobileNo(mobileNo);
		 
		if(customer!=null) {
			
			BigDecimal balance =  customer.getWallet().getBalance();
			Integer walletId= customer.getWallet().getWalletId();
			 
			balance = balance.subtract(amount);
			Wallet wallet=new Wallet(walletId,balance);
			 customer.setWallet(wallet);
			
		     customerRepo.save(customer);
		     log.info("amount " +amount + "  withdrawed successfully");
		     log.info("total available balance:" +balance);
			 return  customer;
		}
			
			else
				log.error("wallet doesnot exist");
				throw new CustomerException("wallet doesnt exist");
			
			
		}


	@Override
	public Customer addAmountToWallet(String mobileNo, BigDecimal amount) throws CustomerException {
		
		

		if(amount.compareTo(new BigDecimal("0.00")) ==0)
		{
			log.error("amount cannot be zero");
			throw new CustomerException("You cannot deposit Zero balance in your account");
			
		} 
		
		if(amount.compareTo(new BigDecimal("0.00")) <0)
		{
			log.error("amount cannot be negative");
			throw new CustomerException(" deposited amount caanot be negative or zero");
		} 
		
		 
		Customer customer  = customerRepo.findByMobileNo(mobileNo);
		
		     if(customer!=null) {
			 
			 BigDecimal balance = customer.getWallet().getBalance();
			 Integer walletId= customer.getWallet().getWalletId();
			 balance = balance.add(amount);
			 Wallet wallet=new Wallet(walletId,balance);
			 customer.setWallet(wallet);
			 log.info("amount " +amount+ " added successfully");
			 return customerRepo.save(customer);
		 }
		
		 else 
			 log.error("failed....");
			 throw new CustomerException("customer not exist");
		 
		 
		
	
		
		
	}

	}
		

	

	
	
	                 
		





    
	
	

	


