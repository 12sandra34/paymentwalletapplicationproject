package com.cg.app.paymentwallet.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;
import com.cg.app.paymentwallet.entity.BankAccount;
import com.cg.app.paymentwallet.exception.CustomerNotFoundException;



public interface BankAccountService {
	
    public BankAccount addAccount(BankAccount account);
	
	public BankAccount removeBankAccount(int accno)throws AccountNotFoundException;
	
	public BankAccount viewAccount(int accno)throws AccountNotFoundException;
	
	public List<BankAccount> viewAllAccounts();
	
	public BankAccount linkAccountToWallet(Integer accountNo,String mobileNo)throws AccountNotFoundException,CustomerNotFoundException;

}
