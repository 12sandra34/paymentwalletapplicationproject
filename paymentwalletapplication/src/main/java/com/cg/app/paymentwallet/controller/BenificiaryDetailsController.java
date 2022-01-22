package com.cg.app.paymentwallet.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.app.paymentwallet.entity.BenificiaryDetails;
import com.cg.app.paymentwallet.exception.BenificiaryDetailsNotFoundException;
import com.cg.app.paymentwallet.service.BenificiaryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BenificiaryDetailsController {
	
	@Autowired
	private BenificiaryService benificiaryService;
	
	@PostMapping("/createBenificiaryDetails")
	public BenificiaryDetails createBenificiaryDetailsHandler(@Valid @RequestBody BenificiaryDetails benificiaryDetails) {
	    log.info("adding benificiary details");
		return  benificiaryService.addBenificiary(benificiaryDetails);
		
		}
	
	@DeleteMapping("/deleteBenificiaryDetails/{benificiaryId}")
	public BenificiaryDetails deleteBenificiaryDetailsHandler(@PathVariable Integer benificiaryId) throws BenificiaryDetailsNotFoundException {
		log.info("deleting benificiary details");
		return benificiaryService.deleteBenificiaryDetails(benificiaryId);
	
	}
	
	@GetMapping("/viewBenificiaryDetails/{benificiaryId}")
      
	public BenificiaryDetails  viewBenificiaryDetailsHandler(@PathVariable Integer benificiaryId)throws BenificiaryDetailsNotFoundException{
		log.info("view benificiary");
		return benificiaryService.viewBenificiary(benificiaryId);
	
	}
	
	@GetMapping("/viewAllBenificiaryDetails")
    
	public List<BenificiaryDetails>  viewAllBenificiaryDetailsHandler()throws BenificiaryDetailsNotFoundException{
		log.info("view all benificiary details");
		return benificiaryService.viewAllBenificiary();
		
	}
}
