package com.cg.app.paymentwallet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
	@NotNull
	@Size(min=3 ,max=50,message="name is mandatory")
    private String name;
	@NotNull
	@Pattern( regexp ="[6-9][0-9]{9}" )
	@Size(min=10,max=10,message="mobile number cannot be null and should contain 10 digit")
	private String mobileNumber;
	@NotNull
	@Email
	private String emailAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private BankAccount account;

}
