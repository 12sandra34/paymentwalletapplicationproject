package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.app.entity.BankAccount;
import com.cg.app.entity.Wallet;

@Repository
public interface AccountRepository extends JpaRepository<BankAccount,Integer> {

	BankAccount findByWallet(Wallet w);
	BankAccount findById(int bid);
}
