package com.cg.app.paymentwallet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@NotNull
	@Size(min=1, max=100,message="bankname is mandatory")
	private String bankName;
	@NotNull
	@Size(min=11,max=11,message="ifsc code is mandatory")
	private String ifscCode;
	private Double balance;
	@OneToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	

}
