package com.cg.app.paymentwallet.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.app.paymentwallet.entity.BillPayment;
import com.cg.app.paymentwallet.entity.BillType;
import com.cg.app.paymentwallet.exception.BillPaymentNotFoundException;
import com.cg.app.paymentwallet.exception.InvalidInputException;
import com.cg.app.paymentwallet.service.BillPaymentService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BillPaymentController {
	
	@Autowired
	private BillPaymentService billPaymentService;
	
	@PostMapping("/addBill")
	public BillPayment addBillPayaddBillPaymentment(@RequestBody BillPayment payment)throws InvalidInputException
	{
		log.info("adding billpayments");
		return billPaymentService.addBillPayment(payment);
			}
	
	@GetMapping("/viewBillPayment")
	public List<BillPayment> viewBillPayment()
	{
		log.info("view bill payments");
		return billPaymentService.viewBillPayment();
		
	}
}
