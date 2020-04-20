package com.tradeai.demandcontract.state;



import org.springframework.stereotype.Component;

import com.tradeai.demandcontract.dto.DemandContractDTO;



@Component("NewPendingState")
public class NewPendingState implements DemandActivityState {

	@Override
	public DemandContractDTO processActivity(DemandContractDTO dto ) {
		
		return dto;


		
	}



	



}
