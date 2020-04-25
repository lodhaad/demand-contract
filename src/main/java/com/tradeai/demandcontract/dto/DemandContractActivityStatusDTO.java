package com.tradeai.demandcontract.dto;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class DemandContractActivityStatusDTO {

	private Integer contractActivityStatusId;

	private Integer contractId;

	private Integer contractActivityId;

	private String activityType;

	private String activityState;

	private Date activityStateDate;

	private LocalDateTime activityStateTimestamp;

}
