package com.cg.app.paymentwallet.service;

import java.util.List;

import com.cg.app.paymentwallet.entity.BenificiaryDetails;
import com.cg.app.paymentwallet.exception.BenificiaryDetailsNotFoundException;





public interface BenificiaryService {
	
	public BenificiaryDetails addBenificiary(BenificiaryDetails benificiaryDetails);
	public BenificiaryDetails deleteBenificiaryDetails(Integer benificiaryId)throws BenificiaryDetailsNotFoundException;
    public BenificiaryDetails viewBenificiary(Integer benificiaryId)throws BenificiaryDetailsNotFoundException;
    public List<BenificiaryDetails> viewAllBenificiary();
}
