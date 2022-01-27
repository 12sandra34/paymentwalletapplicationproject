package com.cg.app.paymentwallet.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.app.paymentwallet.entity.Wallet;
import com.cg.app.paymentwallet.exception.WalletException;
import com.cg.app.paymentwallet.service.WalletService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WalletController {
	
	@Autowired
	private WalletService walletService;
	
	@PutMapping("/addAmount/{walletId}/{amount}")
    public Wallet addAmountToWalletHandler(@PathVariable Integer walletId,@PathVariable BigDecimal amount)throws  WalletException{
      
    	log.info("adding amount to wallet");
    	return walletService.addAmountToWallet(walletId, amount);
    	
    	
    }
	
	@GetMapping("/getWallet")
	public List<Wallet>  getAllWalletListHandler()throws WalletException{
		log.info("view all wallet details");
		return walletService.getAllWalletList();

     }

}
