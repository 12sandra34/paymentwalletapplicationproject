package com.cg.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Transaction {
	
	private int transactionId;
	private String transactionType;
	private String transactionDate;
	@OneToOne(cascade=CascadeType.ALL)
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName = "walletId")
	public Wallet wallet;
	private double amount;
	private String description;

}
