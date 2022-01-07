package com.cg.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillPayment {
	
	private Integer billId;
	private Wallet wallet;
	private double amount;
	private BillType billType;
	private LocalDate paymentDate;
	
	
	@Override
	public String toString() {
		return "BillPayment [billId=" + billId + ", wallet=" + wallet + ", amount=" + amount + ", billType=" + billType
				+ ", paymentDate=" + paymentDate + "]";
	}
	
	
	




	

}
