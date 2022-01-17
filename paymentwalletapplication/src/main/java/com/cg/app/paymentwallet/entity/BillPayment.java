package com.cg.app.paymentwallet.entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

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
	@NotNull
	private Double amount;
	@CreationTimestamp
	private LocalDateTime paymentDate;
	@Enumerated(EnumType.STRING)
    private BillType billtype;
    @OneToOne(cascade=CascadeType.ALL)
    private Wallet wallet;

}

