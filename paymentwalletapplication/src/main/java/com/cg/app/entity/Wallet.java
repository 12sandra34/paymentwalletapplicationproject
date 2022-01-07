package com.cg.app.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Wallet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int walletId;
	private BigDecimal balance;
	
	public Wallet() {
		
		
	}
	
	public Wallet(int walletId,BigDecimal balance) {
		
		super();
		this.walletId=walletId;
		this.balance=balance;
	}
	
	
	public void setWALLETID(int walletId) {
		
		this.walletId=walletId;
	}
	
	public int getWALLETID() {
		
		return walletId;
	}
	
	public void setBalance(BigDecimal balance) {
		
		this.balance = balance;
	}
	
	public BigDecimal getBalance() {
		
		return balance;
	}

	@Override
	public String toString() {
		return " [walletId=" + walletId + ", balance=" + balance + "]";
	}
	
	

}
