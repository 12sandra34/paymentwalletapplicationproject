package com.cg.app.paymentwallet.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillPayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;
	private Double amount;
	@CreationTimestamp
	private LocalDateTime paymentDate;
    private BillType billtype;
    @OneToOne(cascade=CascadeType.ALL)
    private Wallet wallet;
}
