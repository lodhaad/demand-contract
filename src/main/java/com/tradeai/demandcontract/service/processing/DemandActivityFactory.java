package com.tradeai.demandcontract.service.processing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ActivityFactory")
public class DemandActivityFactory {

	@Autowired
	NewContractActivityProcess newContractActivityProcess;

	public DemandActivityProcess getActivityType(String activityType) throws Exception {
		if (activityType.equals("N")) {
			return newContractActivityProcess;
		} else {
			throw new Exception(" this contract is not supported");
		}
	}

}
