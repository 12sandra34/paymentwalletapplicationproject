package com.cg.app.paymentwallet.service;

import java.math.BigDecimal;
import java.util.List;
import com.cg.app.paymentwallet.entity.Transaction;
import com.cg.app.paymentwallet.exception.InvalidInputException;

public interface TransactionService {
	
	public Transaction addTransaction(Transaction transaction)throws InvalidInputException; 
	
	public List<Transaction> viewAllTransactions()throws InvalidInputException;
}
