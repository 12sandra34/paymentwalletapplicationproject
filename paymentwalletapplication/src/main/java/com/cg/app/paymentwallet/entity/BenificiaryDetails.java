package com.cg.app.paymentwallet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.springframework.lang.NonNull;
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
	@NonNull
    private String name;
	private String mobileNumber;
	private String emailAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private BankAccount account;



	
}
