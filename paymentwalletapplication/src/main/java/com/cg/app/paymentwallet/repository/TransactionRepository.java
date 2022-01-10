package com.cg.app.paymentwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.app.paymentwallet.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	

}
