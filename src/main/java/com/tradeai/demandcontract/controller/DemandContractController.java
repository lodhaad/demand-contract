package com.tradeai.demandcontract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tradeai.demandcontract.dto.DemandContractDTO;
import com.tradeai.demandcontract.service.DemandContractService;

@Controller
public class DemandContractController {
	
	@Autowired 
	DemandContractService service;
	
	
	
	public void heath() {
		
	}
	
	public String getContract() {
		return "get Contract "; 
		
	}
	
	
	public String postNewContract() throws Exception { 
		
		DemandContractDTO dto = new DemandContractDTO();
		
		service.processContractActivity(dto);
		
		return "post";
		
	}
	
	public String updateContract() throws Exception {
		
		DemandContractDTO dto = new DemandContractDTO();
		
		service.processContractActivity(dto);
		
		return "post";
		
	}

}
