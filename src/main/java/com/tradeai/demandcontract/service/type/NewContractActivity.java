package com.tradeai.demandcontract.service.type;




import org.springframework.beans.factory.annotation.Autowired;

import com.tradeai.demandcontract.dto.DemandContractDTO;
import com.tradeai.demandcontract.state.NewPendingState;
import com.tradeai.demandcontract.state.NewSettledState;

	

public class NewContractActivity implements DemandActivityType {
	
	@Autowired
	private NewPendingState pendingState;
	
	@Autowired
	private NewSettledState settledState;

	@Override
	public DemandContractDTO processActivity(DemandContractDTO dto) throws Exception {
		
		if(dto.getContractActivity().equals("P")) {
			
			return pendingState.processActivity(dto);
			
		}
		else if (dto.getContractActivity().equals("S")) {
			
			return settledState.processActivity(dto);
			
		}
		
		else {
			
			throw new Exception (" this activity state not supported");
			
		}




	}



	


}
