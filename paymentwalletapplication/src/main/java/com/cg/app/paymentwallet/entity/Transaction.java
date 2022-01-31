package com.cg.app.paymentwallet.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	@NotNull
	@Size(message="transaction type cannnot be null")
	private String transactionType;
	@CreationTimestamp
	private LocalDateTime transactionDate;
	private BigDecimal amount;
	@NotNull
	@Size(max=50,message="description cannnot be null")
	private String description;
	@ManyToOne(cascade = CascadeType.ALL)
	public Wallet wallet;
	
}
