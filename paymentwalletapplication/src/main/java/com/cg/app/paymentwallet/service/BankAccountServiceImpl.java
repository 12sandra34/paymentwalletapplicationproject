package com.cg.app.paymentwallet.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.paymentwallet.entity.BankAccount;
import com.cg.app.paymentwallet.entity.Customer;
import com.cg.app.paymentwallet.entity.Wallet;
import com.cg.app.paymentwallet.exception.CustomerNotFoundException;
import com.cg.app.paymentwallet.repository.BankAccountRepository;
import com.cg.app.paymentwallet.repository.CustomerRepository;




@Service
public class BankAccountServiceImpl  implements BankAccountService{
	
	@Autowired
	private BankAccountRepository accountRepo;
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public BankAccount addAccount(BankAccount account) {
		return accountRepo.save(account);
	}

	@Override
	public BankAccount removeBankAccount(int accno) throws AccountNotFoundException {
		
	   Optional<BankAccount> opt= accountRepo.findById(accno);
	
	   if(opt.isPresent()) {
		
		BankAccount account= opt.get();
		
		accountRepo.delete(account);
		
		return account;
	
	}else
		throw new AccountNotFoundException("Account does not exist with the account number"+accno);
	}

	@Override
	public BankAccount viewAccount(int accno) throws AccountNotFoundException {
		return accountRepo.findById(accno)
				.orElseThrow(() -> new AccountNotFoundException("Account does not exist..") );
	}

	@Override
	public List<BankAccount> viewAllAccounts() {
		return accountRepo.findAll();
	}

	@Override
	public BankAccount linkAccountToWallet(Integer accountNo, String mobileNo)
			throws AccountNotFoundException, CustomerNotFoundException {
		
            Customer customer= customerRepo.findByMobileNo(mobileNo);
		
		
		    if(customer == null)
			    throw new CustomerNotFoundException("invalid Mobile number");
		    else{
		
			   Optional<BankAccount> opt= accountRepo.findById(accountNo);
		
			
			    if(opt.isPresent()) {
				
				BankAccount account= opt.get();
				
				Wallet wallet= customer.getWallet();
				
				 account.setWallet(wallet);
				
				return accountRepo.save(account);
				
		
				
			}else
				throw new AccountNotFoundException("Invalid account number");
			
			
			
			
		
		    }
		 
	}

}
