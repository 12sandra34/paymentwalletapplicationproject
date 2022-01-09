package com.cg.app.entity;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	private String name;
	private String mobileNo;
	private String address;
	private String email;
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Wallet wallet;

	public Wallet getWallet() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
