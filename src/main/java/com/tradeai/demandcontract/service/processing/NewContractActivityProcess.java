package com.tradeai.demandcontract.service.processing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradeai.demandcontract.dto.DemandContractDTO;
import com.tradeai.demandcontract.service.state.NewPendingState;
import com.tradeai.demandcontract.service.state.NewSettledState;

@Component("NewContractActivityProcess")
public class NewContractActivityProcess implements DemandActivityProcess {

	@Autowired
	private NewPendingState pendingState;

	@Autowired
	private NewSettledState settledState;

	@Override
	public DemandContractDTO processActivity(DemandContractDTO dto, String activityStatus) throws Exception {

		if (activityStatus.equals("P")) {
			return pendingState.processActivity(dto);
		} else if (activityStatus.equals("S")) {
			return settledState.processActivity(dto);
		} else {
			throw new Exception(" this activity state not supported");
		}

	}

}
