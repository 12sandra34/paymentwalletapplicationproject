package com.cg.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
	
	@Id
	private Integer accountNo;
	private String ifscCode;
	private String bankName;
	private double balance;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName="walletId")
	private Wallet wallet;

	
	@Override
	public String toString() {
		return " [accountNo=" + accountNo + ", ifscCode=" + ifscCode + ", bankName=" + bankName
				+ ", balance=" + balance + "]";
	}

}
