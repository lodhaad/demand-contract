package com.tradeai.demandcontract.state;

import com.tradeai.demandcontract.dto.DemandContractDTO;

public interface DemandActivityState {
	
	public DemandContractDTO processActivity(DemandContractDTO dto);

}
