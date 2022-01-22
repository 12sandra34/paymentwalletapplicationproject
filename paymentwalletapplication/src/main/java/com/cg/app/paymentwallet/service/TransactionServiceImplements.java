package com.cg.app.paymentwallet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.app.paymentwallet.entity.Transaction;
import com.cg.app.paymentwallet.repository.TransactionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionServiceImplements implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepo;
	

	@Override
	public Transaction addTransaction(Transaction transaction) {
	log.info("transaction added successfully");	
	return transactionRepo.save(transaction);
	}

	@Override
	public List<Transaction> viewAllTransaction() {
		log.info("here is all the transaction details");
		return transactionRepo.findAll();
	}

}
