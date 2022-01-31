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
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull
	@Size(min=3,max=50 ,message="name is mandatory ")
	private String name;
	
    
	@NotNull
	@Pattern( regexp ="[6-9][0-9]{9}" )
	@Size(min=10,max=10,message="mobile number length should be 10")
	private String mobileNo;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
	@Size(min=8,max=15,message="entering password is mandatory with minimum size 8 and maximum size 15")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	
	}


