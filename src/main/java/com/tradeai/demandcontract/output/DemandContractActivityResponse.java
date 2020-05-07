package com.tradeai.demandcontract.output;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DemandContractActivityResponse {

	private Integer demandContractActivityId;

	private Integer contractId;

	private String activityType;

	private Double activityPrice;

	private Double activityRate;

	private Integer activityQuantity;

	private String activityState;

	private String activityDate;

	private String activityCreation;

	private String activityUpdation;

	private List<DemandContractActivityStatusResponse> statuses;

}