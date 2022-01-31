package com.cg.app.paymentwallet.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.app.paymentwallet.entity.Transaction;
import com.cg.app.paymentwallet.exception.InvalidInputException;
import com.cg.app.paymentwallet.repository.CustomerRepository;
import com.cg.app.paymentwallet.repository.TransactionRepository;
import com.cg.app.paymentwallet.repository.WalletRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionServiceImplements implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepo;
	@Autowired 
	private WalletRepository walletRepo;

	@Override
	public Transaction addTransaction(Transaction transaction) throws InvalidInputException
	{ 
		boolean b=walletRepo.existsById(transaction.getWallet().getWalletId());
		
		if(!b) {
			log.error("transaction failed");
			throw new InvalidInputException("wallet Id doesnot Exist");
		}
		
		Transaction transactions=new Transaction();
		
		transactions.setTransactionType(transaction.getTransactionType());
		transactions.setAmount(transaction.getAmount());
		
		transactions.setDescription(transaction.getDescription());
		transactions.setWallet(walletRepo.findById(transaction.getWallet().getWalletId()).get());
		log.info("transaction added successfully");
		return transactionRepo.save(transactions);
	}

	@Override
	public List<Transaction> viewAllTransactions() throws InvalidInputException{
		
		
			
			
			log.info("here is the list of transaction");
		   return transactionRepo.findAll();
		}
	}
	
	
	 


	

