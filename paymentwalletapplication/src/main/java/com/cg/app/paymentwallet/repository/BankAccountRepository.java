package com.cg.app.paymentwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.app.paymentwallet.entity.BankAccount;
import com.cg.app.paymentwallet.entity.Customer;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
	
	
	
	
}
