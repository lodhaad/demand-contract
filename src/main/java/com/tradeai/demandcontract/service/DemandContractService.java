package com.tradeai.demandcontract.service;

import com.tradeai.demandcontract.dto.DemandContractDTO;
import com.tradeai.demandcontract.input.ClientContractRequest;

public interface DemandContractService {
	
	public DemandContractDTO processContractActivity(ClientContractRequest contractRequest, String activityType, String activityStatus) throws Exception;
	
	public DemandContractDTO getContractByContractId(Integer contractId);

	
	/**
	 * 
	 * @param contract
	 * @return
	 */
	default DemandContractDTO mapNewContractRequest(ClientContractRequest contract) {
		DemandContractDTO dto = new DemandContractDTO();
		dto.setSecurityCode(contract.getSecurityCode());
		dto.setCurrentPrice(contract.getAskedPrice());
		dto.setOriginalPrice(contract.getAskedPrice());
		dto.setCurrentQuantity(contract.getAskedQuantity());
		dto.setOriginalQuantity(contract.getAskedQuantity());
		dto.setOriginalRate(contract.getAskedRate());
		dto.setCurrentRate(contract.getAskedRate());
		dto.setClientId(contract.getClientId());
		
		return dto;
	}
}
