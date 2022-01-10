package com.cg.app.paymentwallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.paymentwallet.entity.BillPayment;
import com.cg.app.paymentwallet.exception.BenificiaryDetailsNotFoundException;
import com.cg.app.paymentwallet.exception.BillPaymentNotFoundException;
import com.cg.app.paymentwallet.repository.BillPaymentRepository;
import com.cg.app.paymentwallet.repository.TransactionRepository;

@Service
public class BillPaymentServiceImpl implements BillPaymentService {
	
	@Autowired
	private BillPaymentRepository billPaymentRepo;
	@Autowired
	private TransactionRepository transactionRepo;

	@Override
	public BillPayment addBillPayment(BillPayment billPayment) {
		
		
		return billPaymentRepo.save(billPayment);
	}

	@Override
	public List<BillPayment> viewBillPayment() {
		
		return billPaymentRepo.findAll();
	}

	@Override
	public BillPayment viewBill(Integer billId) throws BillPaymentNotFoundException{
	
		return billPaymentRepo.findById(billId)
				.orElseThrow(() -> new BillPaymentNotFoundException("Benificiary not exist..") );
	}

}
