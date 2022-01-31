package com.cg.app.paymentwallet.controller;

import java.math.BigDecimal;



import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.app.paymentwallet.entity.Customer;
import com.cg.app.paymentwallet.entity.LoginBean;
import com.cg.app.paymentwallet.exception.CustomerException;
import com.cg.app.paymentwallet.exception.InsufficientBalanceException;
import com.cg.app.paymentwallet.exception.InvalidInputException;
import com.cg.app.paymentwallet.exception.MobileNumberNotRegistered;
import com.cg.app.paymentwallet.exception.WalletException;
import com.cg.app.paymentwallet.service.CustomerService;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	
	
	@PostMapping("/registerCustomer")
	public Customer registerCustomerHandler(@Valid @RequestBody Customer customer)throws CustomerException {
		
		log.info("inside registerCustomerHandler of controller class...");
			
		return customerService.registerCustomer(customer);
		
	}
	
	
	
	@GetMapping("/getBalance/{mobileNo}")
	public BigDecimal showBalanceHandler(@PathVariable String mobileNo) throws CustomerException {
		
		log.info("getting balance of the customer from the wallet...");
		
		return  customerService.showBalance(mobileNo);
		
		
	}
	
	
	@PostMapping("/loginCustomer")
	public Customer authenticateCustomerHandler( @RequestBody LoginBean loginBean) throws CustomerException {
		log.info("authenticating");
		return customerService.authenticateCustomer(loginBean.getUsername(), loginBean.getPassword());
		
		
	}
	
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	
	public Customer deleteCustomerByIdNoHandler(@PathVariable Integer customerId)throws CustomerException{
		log.info("deleting customer details");
		return customerService.deleteCustomerById(customerId);
		
	}
	
    @GetMapping("/getCustomer")
    
	public List<Customer>  getAllCustomerListHandler()throws CustomerException{
		log.info("viewing all customer details");
		return customerService.getAllCustomerList();

     }
    
   
    
    
    
    @PutMapping("/withdrawAmount/{mobileNo}/{amount}")
    public Customer withdrawAmount(@PathVariable String mobileNo, @PathVariable BigDecimal amount)throws CustomerException{
    	log.info("withdrawing amount");
    	return customerService.withdrawAmount(mobileNo, amount);
	}
    
    
    @PutMapping("/transferMoney/{sourceMobileNo}/{targetMobileNo}/{amount}")
    public Customer fundTransferHandler(@PathVariable String sourceMobileNo,@PathVariable String targetMobileNo,@PathVariable BigDecimal amount) throws CustomerException,InvalidInputException,InsufficientBalanceException
    {
    	log.info("transfering amount from sourcemobileNo to targetmobileNo");
    return customerService.fundTransfer(sourceMobileNo, targetMobileNo,amount);
	
   
    }

    
    
    @PutMapping("/addAmount/{mobileNo}/{amount}")
    public Customer addAmountToWalletHandler(@PathVariable String mobileNo,@PathVariable BigDecimal amount) throws CustomerException  {
    	log.info("adding amount to wallet");
    	 return	customerService.addAmountToWallet(mobileNo, amount);
    	
    	}

    
   
}
