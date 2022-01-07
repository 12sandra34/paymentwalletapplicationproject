package com.cg.app.entity;

import java.time.LocalDate;

public class BillPayment {
	
	private int billId;
	private Wallet wallet;
	private double amount;
	private LocalDate paymentDate;
	
	
	public BillPayment() {
		
	}


	public BillPayment(int billId, Wallet wallet, double amount, LocalDate paymentDate) {
		super();
		this.billId = billId;
		this.wallet = wallet;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}


	public int getBillId() {
		return billId;
	}


	public void setBillId(int billId) {
		this.billId = billId;
	}


	public Wallet getWallet() {
		return wallet;
	}


	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public LocalDate getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}


	@Override
	public String toString() {
		return "[billId=" + billId + ", wallet=" + wallet + ", amount=" + amount + ", paymentDate="
				+ paymentDate + "]";
	}
    
	

}
