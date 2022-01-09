package com.cg.app.entity;

import java.util.List;


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
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountNo;
	
	private String bankName;
	
	private String ifscCode;
	
	private Double balance;
	
	@OneToOne
	private Wallet wallet;
	
}

