package com.cg.app.paymentwallet.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.app.paymentwallet.entity.Transaction;
import com.cg.app.paymentwallet.exception.InvalidInputException;
import com.cg.app.paymentwallet.exception.TransactionDetailsNotFoundException;
import com.cg.app.paymentwallet.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	
	
	
	@PostMapping("/addTransaction")
	  public Transaction addTranscationHandler(@RequestBody Transaction transaction)throws InvalidInputException
	  {
		log.info("adding transactions");
		  return transactionService.addTransaction(transaction);
		 
	  }	
	  
	@GetMapping("/viewAllTransactions")
	public List<Transaction> viewAllTransactions() throws InvalidInputException{
		log.info("view transactions by wallet");
		return transactionService.viewAllTransactions();	
	}
	

}