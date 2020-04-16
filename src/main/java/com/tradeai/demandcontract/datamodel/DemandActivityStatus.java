package com.tradeai.demandcontract.datamodel;

import java.sql.Date;
import java.time.LocalDateTime;

public class DemandActivityStatus {
	
	private Integer contractActivityStatusId;

	private Integer contractId;

	private Integer contractActivityId;

	private String activityType;

	private String activityState;

	private Date activityStateDate;

	private LocalDateTime activityStateTimestamp;

}
