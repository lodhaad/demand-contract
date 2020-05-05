package com.tradeai.demandcontract.output;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DemandContractActivityStatusResponse {
	
	private Integer contractActivityStatusId;

	private Integer contractId;

	private Integer contractActivityId;

	private String activityType;

	private String activityState;

	private Date activityStateDate;

	private LocalDateTime activityStateTimestamp;


}
