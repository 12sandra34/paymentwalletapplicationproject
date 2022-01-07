package com.cg.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.entity.BankAccount;
import com.cg.app.entity.Wallet;
import com.cg.app.repository.AccountRepository;
import com.cg.app.repository.WalletRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository ar;
	 
	@Autowired
	WalletRepository wr;
	
	@Override
	public Wallet addAccount(BankAccount bankAcc) {
		
	  Wallet w= bankAcc.getWallet();
	  
	  if(wr.existsById(w.getWALLETID())) && !ar.existsById(bankAcc.getAccountNo(), ){
		  
	  }
	}
	

}
