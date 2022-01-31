package com.cg.app.paymentwallet.entity;






import com.fasterxml.jackson.annotation.JsonCreator;






public enum BillType {
	
	DTH("dth"),MOBILE("mobile"),ELECTRICITY("electricity");
	
	private String billCode;
	
	private BillType(String billCode) {
		this.billCode=billCode;
	}
	
	public String getBillCode() {
		return this.billCode;
	}
	
	@JsonCreator
	public static BillType getBillType(String value) {
		
		for(BillType bill:BillType.values()) {
			if(bill.getBillCode().equals(value)) {
				
				return bill;
			}
		}
		
		return null;
	}

}
