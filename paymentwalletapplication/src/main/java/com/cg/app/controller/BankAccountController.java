package com.cg.app.controller;

import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.entity.BankAccount;
import com.cg.app.services.BankAccountService;

@RestController
@RequestMapping("/bank")
public class BankAccountController {
	
	
	@Autowired
	private BankAccountService bankService;
	
	
	@PostMapping("/createBankAccount")
	public BankAccount createAccountHandler(@RequestBody BankAccount account) {
	
		return  bankService.addAccount(account);
		
		
	}
	
	
	@PutMapping("/linkWalletToAccount/{accountNo}/{mobileNo}")
	public BankAccount attachWalletToAccountHandler(@PathVariable Integer accountNo,@PathVariable String mobileNo) {
		
		return bankService.linkAccountToWallet(accountNo, mobileNo);
		
	}
}

	
	
	