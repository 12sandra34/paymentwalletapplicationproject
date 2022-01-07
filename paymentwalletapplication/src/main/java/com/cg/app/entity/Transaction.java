package com.cg.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	private Integer transactionId;
	private String transactionType;
	private String transactionDate;
	@OneToOne(cascade=CascadeType.ALL)
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName = "walletId")
	public Wallet wallet;
	private double amount;
	private String description;
	


	@Override
	public String toString() {
		return "[transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", transactionDate=" + transactionDate + ", wallet=" + wallet + ", amount=" + amount
				+ ", description=" + description + "]";
	}
	
	
	

}
