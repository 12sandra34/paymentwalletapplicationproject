package com.cg.app.paymentwallet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.app.paymentwallet.entity.BillPayment;
import com.cg.app.paymentwallet.exception.BillPaymentNotFoundException;
import com.cg.app.paymentwallet.repository.BillPaymentRepository;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BillPaymentServiceImpl implements BillPaymentService {
	
	@Autowired
	private BillPaymentRepository billPaymentRepo;
	
	@Override
	public BillPayment addBillPayment(BillPayment billPayment) {
		log.info("bill added succesfully");
		return billPaymentRepo.save(billPayment);
		
	}

	@Override
	public List<BillPayment> viewBillPayment() {
		log.info("here is all the bill details");
		return billPaymentRepo.findAll();
	}

	@Override
	public BillPayment viewBill(Integer billId) throws BillPaymentNotFoundException{
	    log.info("here is the bill details");
		return billPaymentRepo.findById(billId)
				.orElseThrow(() -> new BillPaymentNotFoundException("bill not exist..") );
	}

}
