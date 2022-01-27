package com.cg.app.paymentwallet.service;

import java.math.BigDecimal;
import java.util.List;

import com.cg.app.paymentwallet.entity.Wallet;
import com.cg.app.paymentwallet.exception.WalletException;

public interface WalletService {
	
	public Wallet addAmountToWallet(Integer walletId,BigDecimal balance) throws WalletException;
	public List<Wallet> getAllWalletList();

}
