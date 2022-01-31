package com.cg.app.paymentwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.app.paymentwallet.entity.Customer;
import com.cg.app.paymentwallet.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
	
	
	
	
}
