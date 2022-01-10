package com.cg.app.paymentwallet.service;

import java.util.List;

import com.cg.app.paymentwallet.entity.BillPayment;
import com.cg.app.paymentwallet.exception.BillPaymentNotFoundException;

public interface BillPaymentService {
	
	public BillPayment addBillPayment(BillPayment billPayment);
	public BillPayment viewBill(Integer billId) throws BillPaymentNotFoundException;
	public List<BillPayment> viewBillPayment();

}
