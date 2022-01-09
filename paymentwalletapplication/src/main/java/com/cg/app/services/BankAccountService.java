package com.cg.app.services;

import java.util.List;
import com.cg.app.exceptions.AccountNotFoundException;
import com.cg.app.exceptions.CustomerNotFoundException;
import com.cg.app.entity.BankAccount;

public interface BankAccountService {

	public BankAccount addAccount(BankAccount account);
	
	public BankAccount removeBankAccount(int accno)throws AccountNotFoundException;
	
	public BankAccount viewAccount(int accno)throws AccountNotFoundException;
	
	public List<BankAccount> viewAllAccounts();
	
	public BankAccount linkAccountToWallet(Integer accountNo,String mobileNo)throws AccountNotFoundException,CustomerNotFoundException;
}

