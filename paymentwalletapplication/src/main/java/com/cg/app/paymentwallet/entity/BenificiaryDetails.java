package com.cg.app.paymentwallet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenificiaryDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer benificiaryId;
	@NotNull(message="name is mandatory")
    private String name;
	@Size(min=10,max=10)
	private String mobileNumber;
	@Email
	private String emailAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private BankAccount account;



	
}
