package com.cg.app.paymentwallet.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.app.paymentwallet.entity.Transaction;
import com.cg.app.paymentwallet.exception.TransactionDetailsNotFoundException;
import com.cg.app.paymentwallet.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	
	
	@PostMapping("/addTransaction/{fromWalletId}/{toWalletId}")
	
	public Transaction addTransactionHandler(@RequestBody Transaction transaction,@PathVariable("fromWalletId") Integer WalletId,@PathVariable("toWalletId") Integer WalletIds) {
		
		log.info("adding transaction details ");
		return transactionService.addTransaction(transaction);
	}
	
	
	@GetMapping("/viewAllTransaction")
    public List<Transaction>  viewAllTransactioListHandler()throws TransactionDetailsNotFoundException{
		log.info("view transactions");
		return transactionService.viewAllTransaction();

}

}