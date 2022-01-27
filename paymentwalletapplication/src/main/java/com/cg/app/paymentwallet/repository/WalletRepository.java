package com.cg.app.paymentwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.app.paymentwallet.entity.Wallet;


@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

	
}
