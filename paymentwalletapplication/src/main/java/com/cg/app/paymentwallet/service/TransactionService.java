package com.cg.app.paymentwallet.service;

import java.util.List;
import com.cg.app.paymentwallet.entity.Transaction;

public interface TransactionService {
	
	public Transaction addTransaction(Transaction transaction);
    public List<Transaction> viewAllTransaction();
}
