package com.tradeai.demandcontract.service.processing;

import com.tradeai.demandcontract.dto.DemandContractDTO;

public interface DemandActivityProcess {

	public DemandContractDTO processActivity(DemandContractDTO dto, String activityStatus) throws Exception;

}
