package com.tradeai.demandcontract.service.processing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradeai.demandcontract.dto.DemandContractDTO;
import com.tradeai.demandcontract.service.type.DemandActivityType;

@Component("ActivityFactory")

public class DemandActivityFactory {
	
	@Autowired
	DemandActivityType newActivity;
	
	public DemandActivityType processActivity(DemandContractDTO dto) throws Exception {
		
		if (dto.getContractActivity().equals("N")) {
			
			return newActivity;
			
		}
		else { 
			
			throw new Exception (" this contract is not supported");
			
		}


		
	}

}
