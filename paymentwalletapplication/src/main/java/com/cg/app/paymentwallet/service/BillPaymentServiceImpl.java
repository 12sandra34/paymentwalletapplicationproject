package com.cg.app.paymentwallet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.app.paymentwallet.entity.BillPayment;
import com.cg.app.paymentwallet.exception.BillPaymentNotFoundException;
import com.cg.app.paymentwallet.exception.InvalidInputException;
import com.cg.app.paymentwallet.repository.BillPaymentRepository;
import com.cg.app.paymentwallet.repository.CustomerRepository;
import com.cg.app.paymentwallet.repository.WalletRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BillPaymentServiceImpl implements BillPaymentService {
	
	@Autowired
	private BillPaymentRepository billPaymentRepo;
	@Autowired 
	private WalletRepository walletRepo;
	@Autowired
	private CustomerRepository customerRep;
	
	
	
	@Override
	public BillPayment addBillPayment(BillPayment payment)throws InvalidInputException{
		
		
		
		boolean b=walletRepo.existsById(payment.getWallet().getWalletId());
		if(!b) {
			log.error("bill cannot add");
			throw new InvalidInputException("Wallet doesnot exist");
		}
		BillPayment bill=new BillPayment();
		
		bill.setBilltype(payment.getBilltype());
		bill.setAmount(payment.getAmount());
		bill.setWallet(walletRepo.findById(payment.getWallet().getWalletId()).get());
		log.info("bill added successfully");
		return billPaymentRepo.save(bill);
	}
	

	@Override
	public List<BillPayment> viewBillPayment() {
		
		List<BillPayment> viewBill=billPaymentRepo.findAll();
        log.info("here is the list of bill");
		return viewBill;
	}

}
