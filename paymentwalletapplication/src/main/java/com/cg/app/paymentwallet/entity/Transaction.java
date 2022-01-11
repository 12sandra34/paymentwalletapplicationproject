package com.cg.app.paymentwallet.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
	private String transactionType;
	@CreationTimestamp
	private LocalDateTime transactionDate;
	private Double amount;
	@NotNull
	private String description;
	
	
	
	

}
