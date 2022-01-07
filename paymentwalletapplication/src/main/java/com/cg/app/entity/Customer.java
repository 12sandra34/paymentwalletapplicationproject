package com.cg.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	
	private String userName;
	@Id
	private String mobileNumber;
	private String password;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="walletId")
	private Wallet wallet;
	
	public Customer() {
		
	}

	public Customer(String userName, String mobileNumber, String password, Wallet wallet) {
		super();
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.wallet = wallet;
	}

	
	@Override
	public String toString() {
		return " [userName=" + userName + ", mobileNumber=" + mobileNumber + ", password=" + password
				+ ", wallet=" + wallet + "]";
	}
	
	
	
	

}
