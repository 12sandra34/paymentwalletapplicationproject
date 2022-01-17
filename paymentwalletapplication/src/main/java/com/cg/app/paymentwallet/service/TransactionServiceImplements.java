package com.cg.app.paymentwallet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.app.paymentwallet.entity.Transaction;
import com.cg.app.paymentwallet.repository.TransactionRepository;

@Service
public class TransactionServiceImplements implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepo;
	

	@Override
	public Transaction addTransaction(Transaction transaction) {
		
	
		
		return transactionRepo.save(transaction);
	}

	@Override
	public List<Transaction> viewAllTransaction() {
		
		return transactionRepo.findAll();
	}

}
