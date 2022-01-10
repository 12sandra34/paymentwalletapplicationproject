package com.cg.app.paymentwallet.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.app.paymentwallet.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	
public Customer findByMobileNo(String mobileNo);
public Customer deleteByMobileNo(String mobileNo);
	
	
	@Query("from Customer where mobileNo=?1 AND password=?2")
	public Customer validateCustomer(String mobileNo,String password);
	
	@Query("delete from Customer where mobileNo=?1")
	public Customer deleteCustomerByMobileNumber(String mobileNo) ;

}
