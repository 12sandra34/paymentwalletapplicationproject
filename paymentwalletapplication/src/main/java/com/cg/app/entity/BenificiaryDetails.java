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
public class BenificiaryDetails {
	
	@Id
	private Integer benificiaryId;
	private String name;
	private String mobileNumber;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "walletId")
	private Wallet wallet;



	@Override
	public String toString() {
		return " [benificiaryId=" + benificiaryId + ", name=" + name + ", mobileNumber="
				+ mobileNumber + ", wallet=" + wallet + "]";
	}

}
