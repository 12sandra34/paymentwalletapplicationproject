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

@RestController
public class BillPaymentController {
	
	@Autowired
	private BillPaymentService billPaymentService;
	
	@PostMapping("/addBillPayment")
	
	public BillPayment addBillPayment(@RequestBody BillPayment billPayment) {
		
		return billPaymentService.addBillPayment(billPayment);
	}
	
	
    @GetMapping("/getBillPayment")
    
	public List<BillPayment>  getAllBillPaymentListHandler()throws BillPaymentNotFoundException{
		
		return billPaymentService.viewBillPayment();
	
    }
    
    
    @GetMapping("/viewBillPaymentDetails/{billId}")
    
	public BillPayment  viewBenificiaryDetailsHandler(@PathVariable Integer billId) throws BillPaymentNotFoundException{
		
		return billPaymentService.viewBill(billId);
	}

}
