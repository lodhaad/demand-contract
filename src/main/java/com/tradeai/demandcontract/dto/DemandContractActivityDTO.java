package com.tradeai.demandcontract.dto;



import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import lombok.Data;


@Data
public class DemandContractActivityDTO {

	private Integer demandContractActivityId;
	
	private Integer contractId;
	
	private String activityType;

	private Double activityPrice;

	private Double activityRate;

	private Integer activityQuantity;

	private String activityState;

	private Date activityDate;

	private LocalDateTime activityCreation;

	private LocalDateTime activityUpdation;

	private List<DemandContractActivityStatusDTO> statuses;

}
