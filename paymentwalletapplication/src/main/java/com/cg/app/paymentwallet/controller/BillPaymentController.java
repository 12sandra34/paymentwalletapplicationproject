package com.cg.app.paymentwallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.paymentwallet.entity.BenificiaryDetails;
import com.cg.app.paymentwallet.entity.BillPayment;
import com.cg.app.paymentwallet.exception.BenificiaryDetailsNotFoundException;
import com.cg.app.paymentwallet.exception.BillPaymentNotFoundException;
import com.cg.app.paymentwallet.service.BillPaymentService;
import com.cg.app.paymentwallet.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BillPaymentController {
	
	@Autowired
	private BillPaymentService billPaymentService;
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/addBillPayment")
	
	public BillPayment addBillPayment(@RequestBody BillPayment billPayment)  {

		log.info("adding billpayment");
		return billPaymentService.addBillPayment(billPayment);
	}
	
	
    @GetMapping("/getBillPayment")
    
	public List<BillPayment>  getAllBillPaymentListHandler()throws BillPaymentNotFoundException{
		log.info("get bill");
		return billPaymentService.viewBillPayment();
	
    }
    
    
    @GetMapping("/viewBillPaymentDetails/{billId}")
    
	public BillPayment  viewBenificiaryDetailsHandler(@PathVariable Integer billId) throws BillPaymentNotFoundException{
		log.info("view bill");
		return billPaymentService.viewBill(billId);
	}

}
