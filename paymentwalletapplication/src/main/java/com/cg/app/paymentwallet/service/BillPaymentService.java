package com.cg.app.paymentwallet.service;

import java.util.List;

import com.cg.app.paymentwallet.entity.BillPayment;
import com.cg.app.paymentwallet.exception.BillPaymentNotFoundException;
import com.cg.app.paymentwallet.exception.InvalidInputException;

public interface BillPaymentService {
	
	public BillPayment addBillPayment(BillPayment billPayment)throws InvalidInputException;
	public List<BillPayment> viewBillPayment();

}
