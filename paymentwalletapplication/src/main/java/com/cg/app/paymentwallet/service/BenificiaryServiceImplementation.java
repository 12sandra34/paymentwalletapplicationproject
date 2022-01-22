package com.cg.app.paymentwallet.service;

import java.util.List;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.app.paymentwallet.entity.BenificiaryDetails;
import com.cg.app.paymentwallet.exception.BenificiaryDetailsNotFoundException;
import com.cg.app.paymentwallet.repository.BenificiaryRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BenificiaryServiceImplementation implements BenificiaryService{
	
	
	@Autowired
	private BenificiaryRepository benificiaryRepo; 
	

	@Override
	public BenificiaryDetails addBenificiary(BenificiaryDetails benificiaryDetails) {
		log.info("benificiary added successfully");
		return benificiaryRepo.save(benificiaryDetails);
		
		
		
		
	}

	@Override
	public BenificiaryDetails deleteBenificiaryDetails(Integer benificiaryId) throws BenificiaryDetailsNotFoundException {
		log.info("checking benificiarydetails");
		
		Optional<BenificiaryDetails> opt= benificiaryRepo.findById(benificiaryId);
		  
		    if(opt.isPresent()) {
		    	
		    	BenificiaryDetails benificiaryDetails =opt.get();
		    	benificiaryRepo.delete(benificiaryDetails);
		    	log.info("successfully record has been deleted");
		    	return benificiaryDetails;
		    	
				
			}else
				log.error("details not existing");
				throw new BenificiaryDetailsNotFoundException("BenificiaryDetails does not exist with the benificiaryId :"+benificiaryId);
		    	
		    
		    
		    
	}

	@Override
	public BenificiaryDetails viewBenificiary(Integer benificiaryId) throws BenificiaryDetailsNotFoundException {
		log.info("here is the benificiary details");
		return benificiaryRepo.findById(benificiaryId)
				.orElseThrow(() -> new BenificiaryDetailsNotFoundException("Benificiary not exist..") );
	}

	@Override
	public List<BenificiaryDetails> viewAllBenificiary() {
		log.info("here is all the benificiary details");
		return benificiaryRepo.findAll();
		
	}

}
