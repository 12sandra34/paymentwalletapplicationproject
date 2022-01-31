package com.cg.app.paymentwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.app.paymentwallet.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	@Query("select t from Transaction t where transactionType=:transactionType")
	public Transaction viewTransaction(@Param("transactionType") String transactionType);
		
	

}
