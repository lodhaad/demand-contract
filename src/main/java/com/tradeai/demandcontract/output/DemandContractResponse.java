package com.tradeai.demandcontract.output;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;




import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class DemandContractResponse {
	
	private Integer demandContractId;

	private String clientId;

	private String securityCode;

	private Integer originalQuantity;

	private Integer currentQuantity;

	private Double originalRate;

	private Double currentRate;

	private Double originalPrice;

	private Double currentPrice;

	private Date contractBookingDate;

	 private LocalDate timestamp;

	private String contractStatus;
	
	private List<DemandContractActivityResponse> activities;

}
