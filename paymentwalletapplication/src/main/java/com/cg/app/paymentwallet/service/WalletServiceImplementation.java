package com.cg.app.paymentwallet.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.paymentwallet.entity.Wallet;
import com.cg.app.paymentwallet.exception.WalletException;
import com.cg.app.paymentwallet.repository.WalletRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WalletServiceImplementation implements WalletService {
	
	@Autowired
	private WalletRepository walletRepo;

	@Override
	public Wallet addAmountToWallet(Integer walletId,BigDecimal amount) throws WalletException{
		
		Optional<Wallet> opt = walletRepo.findById(walletId);
		if(!opt.isPresent()) {
			log.error("wallet doesnot exist");
			throw new WalletException("wallet doesnt exist");
		}
		else {
			
			Wallet wallet = opt.get();
			BigDecimal balance = wallet.getBalance();
			balance=balance.add(amount);
			wallet.setBalance(balance);
			log.info("amount added to wallet");
			return walletRepo.save(wallet);
		}
		
		
	}

	@Override
	public List<Wallet> getAllWalletList() {
		
		log.info("All wallet details are here");
		return walletRepo.findAll();
	}

}
