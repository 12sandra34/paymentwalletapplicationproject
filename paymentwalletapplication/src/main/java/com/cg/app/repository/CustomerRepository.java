package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.app.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	
	public Customer findByMobileNo(String mobileNo);
	
	
	@Query("from Customer where mobileNo=?1 AND password=?2")
	public Customer validateCustomer(String mobileNo,String password);


	
	
	
	
	
	
}
