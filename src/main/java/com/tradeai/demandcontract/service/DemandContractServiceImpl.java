package com.tradeai.demandcontract.service;

import com.tradeai.demandcontract.dto.DemandContractDTO;
import com.tradeai.demandcontract.service.processing.DemandActivityFactory;

public class DemandContractServiceImpl implements DemandContractService {
	
	private DemandActivityFactory factory;

	@Override
	public DemandContractDTO processContractActivity(DemandContractDTO contractDTO) throws Exception {


		return factory.processActivity(contractDTO).processActivity(contractDTO);
	}

}
