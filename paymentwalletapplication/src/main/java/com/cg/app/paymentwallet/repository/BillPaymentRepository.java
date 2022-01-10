package com.cg.app.paymentwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.app.paymentwallet.entity.BillPayment;

@Repository
public interface BillPaymentRepository extends JpaRepository<BillPayment, Integer> {

}
