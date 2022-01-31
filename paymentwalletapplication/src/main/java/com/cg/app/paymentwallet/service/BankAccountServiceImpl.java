package com.cg.app.paymentwallet.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.paymentwallet.entity.BankAccount;
import com.cg.app.paymentwallet.entity.Customer;
import com.cg.app.paymentwallet.entity.Wallet;
import com.cg.app.paymentwallet.exception.CustomerException;
import com.cg.app.paymentwallet.repository.BankAccountRepository;
import com.cg.app.paymentwallet.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;




@Service
@Slf4j
public class BankAccountServiceImpl  implements BankAccountService{
	
	@Autowired
	private BankAccountRepository accountRepo;
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public BankAccount addAccount(BankAccount account) {
		log.info("Bank account added");
		return accountRepo.save(account);
	}

	@Override
	public BankAccount removeBankAccount(int accno) throws AccountNotFoundException {
		
	   Optional<BankAccount> opt= accountRepo.findById(accno);
	
	   if(opt.isPresent()) {
		
		BankAccount account= opt.get();
		
		accountRepo.delete(account);
		log.info("bank account deleted");
		
		return account;
	
	}else
		log.error("bank account does not exist");
		throw new AccountNotFoundException("Account does not exist with the account number"+accno);
	}

	@Override
	public BankAccount viewAccount(int accno) throws AccountNotFoundException {
		log.info("here is account details");
		return accountRepo.findById(accno)
				.orElseThrow(() -> new AccountNotFoundException("Account does not exist..") );
	}

	@Override
	public List<BankAccount> viewAllAccounts() {
		log.info("here is all bank account details");
		return accountRepo.findAll();
	}

	@Override
	public BankAccount linkAccountToWallet(Integer accountNo, String mobileNo)
			throws AccountNotFoundException, CustomerException {
		
            Customer customer= customerRepo.findByMobileNo(mobileNo);
		
		
		    if(customer == null) {
		    	log.error("could not  link due to invalid mobile number");
			    throw new CustomerException("invalid Mobile number");
		    }
		    else{
		
			   Optional<BankAccount> opt= accountRepo.findById(accountNo);
		
			
			    if(opt.isPresent()) {
				
				BankAccount account= opt.get();
				
				Wallet wallet= customer.getWallet();
				
				 account.setWallet(wallet);
				 log.info("account linked with wallet");
				
				return accountRepo.save(account);
				
		
				
			}else
				log.error("declined due to invalid account number");
				throw new AccountNotFoundException("Invalid account number");
			
			
			
			
		
		    }
		 
	}

}
