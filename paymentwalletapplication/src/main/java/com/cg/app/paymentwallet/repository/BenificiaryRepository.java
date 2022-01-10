package com.cg.app.paymentwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.app.paymentwallet.entity.BenificiaryDetails;

@Repository
public interface BenificiaryRepository extends JpaRepository<BenificiaryDetails, Integer>{

}
