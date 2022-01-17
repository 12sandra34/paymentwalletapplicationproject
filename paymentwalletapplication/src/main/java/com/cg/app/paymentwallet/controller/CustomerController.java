package com.cg.app.paymentwallet.controller;

import java.math.BigDecimal;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.cg.app.paymentwallet.entity.Wallet;
import com.cg.app.paymentwallet.exception.CustomerNotFoundException;
import com.cg.app.paymentwallet.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	
	@PostMapping("/registerCustomer")
	public Customer registerCustomerHandler(@Valid @RequestBody Customer customer) {
		
		log.info("inside registerCustomerHandler of controller class...");
			
		return customerService.registerCustomer(customer);
		
	}
	
	
	
	@GetMapping("/getBalance/{mobileNo}")
	public BigDecimal showBalanceHandler(@PathVariable String mobileNo) throws CustomerNotFoundException {
		
		log.info("getting balance of the customer from the wallet...");
		
		return  customerService.showBalance(mobileNo);
		
		
	}
	
	
	@PostMapping("/loginCustomer")
	public Customer authenticateCustomerHandler( @RequestBody LoginBean loginBean) throws CustomerNotFoundException {
		log.info("authenticating");
		return customerService.authenticateCustomer(loginBean.getUsername(), loginBean.getPassword());
		
		
	}
	
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	
	public Customer deleteCustomerByIdNoHandler(@PathVariable Integer customerId)throws CustomerNotFoundException{
		log.info("deleting customer details");
		return customerService.deleteCustomerById(customerId);
		
	}
	
    @GetMapping("/getCustomer")
    
	public List<Customer>  getAllCustomerListHandler()throws CustomerNotFoundException{
		
		return customerService.getAllCustomerList();

     }
    
    @PutMapping("/addAmount/{mobileNo}/{amount}")
    public Customer addAmountToWalletHandler(@PathVariable String mobileNo,@PathVariable BigDecimal amount)throws CustomerNotFoundException{
      
    	
    	return customerService.addAmountToWallet(mobileNo,amount);
    	
    	
    }
}
