package com.tradeai.demandcontract.state;

import org.springframework.stereotype.Component;

import com.tradeai.demandcontract.dto.DemandContractDTO;

@Component("NewSettledState")
public class NewSettledState implements DemandActivityState {


	@Override
	public DemandContractDTO processActivity(DemandContractDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
