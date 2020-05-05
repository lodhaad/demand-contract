package com.tradeai.demandcontract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradeai.demandcontract.dto.DemandContractDTO;
import com.tradeai.demandcontract.input.ClientContractRequest;
import com.tradeai.demandcontract.output.ClientContractOutput;
import com.tradeai.demandcontract.service.DemandContractService;

@RestController
@RequestMapping("/demand-contract")
public class DemandContractController {
	
	@Autowired 
	DemandContractService service;
	
	
	
	public void health() {
		
	}
	
	@GetMapping(path = "/{contractId}")
	public ResponseEntity<ClientContractOutput> getContract(@PathVariable String contractId) {
		DemandContractDTO contractDTO = service.getContractByContractId(Integer.parseInt(contractId));
		ClientContractOutput clientContractOutput = new ClientContractOutput();
		clientContractOutput.setDemandContract(contractDTO);
		return new ResponseEntity<ClientContractOutput>(clientContractOutput, HttpStatus.OK);
		
	}
	
	@PostMapping

	public ResponseEntity<ClientContractOutput>  addContract(@RequestBody ClientContractRequest contractRequest) throws Exception { 
		
		DemandContractDTO contractDTO  = service.processContractActivity(contractRequest,"N", "P");
		
		ClientContractOutput clientContractOutput = new ClientContractOutput();
		clientContractOutput.setDemandContract(contractDTO);
		
		return new ResponseEntity<ClientContractOutput>(clientContractOutput, HttpStatus.OK);
		
	}
	
}
