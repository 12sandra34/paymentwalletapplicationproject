package com.cg.app.paymentwallet.controller;

import javax.security.auth.login.AccountNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.app.paymentwallet.entity.BankAccount;
import com.cg.app.paymentwallet.exception.CustomerNotFoundException;
import com.cg.app.paymentwallet.service.BankAccountService;
import com.cg.app.paymentwallet.service.CustomerService;



@RestController
public class BankAccountController {
	
	
	
	@Autowired
	private BankAccountService bankService;
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/createBankAccount")
	public BankAccount createAccountHandler(@RequestBody BankAccount account) {
	
		return  bankService.addAccount(account);
		
		
	}
	
	
	@PutMapping("/linkWalletToAccount/{accountNo}/{mobileNo}")
	public BankAccount attachWalletToAccountHandler(@PathVariable Integer accountNo,@PathVariable String mobileNo) throws AccountNotFoundException, CustomerNotFoundException {
		
		return bankService.linkAccountToWallet(accountNo, mobileNo);
		
	}
	
	@DeleteMapping("/removeAccount/{accountNo}")
			
	public BankAccount removeBankAccountHandler(@PathVariable Integer accountNo ) throws AccountNotFoundException,CustomerNotFoundException {
		
		return bankService.removeBankAccount(accountNo);
		
}
	


}
