package com.cg.app.paymentwallet.entity;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer walletId;
	private BigDecimal balance;
    
}
