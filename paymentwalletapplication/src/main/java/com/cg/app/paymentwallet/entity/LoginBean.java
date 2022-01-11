package com.cg.app.paymentwallet.entity;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginBean {
	@NotNull
	private String username;
	@NotNull
	@Size(min=6,max=10)
	private String password;

}
