package com.cg.app.paymentwallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.app.paymentwallet.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	
	
	
	
	@Query("from Customer where mobileNo=?1 AND password=?2")
	public Customer validateCustomer(String mobileNo,String password);
	
	@Query("select c from Customer c where c.mobileNo=:mobileNo")
	public Customer findByMobileNo(@Param(value = "mobileNo") String mobileNo);
	
	
	




	
	
	
	
	
	
}
