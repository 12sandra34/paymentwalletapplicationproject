package com.cg.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return " [userName=" + userName + ", mobileNumber=" + mobileNumber + ", password=" + password
				+ ", wallet=" + wallet + "]";
	}
	
	
	
	

}
