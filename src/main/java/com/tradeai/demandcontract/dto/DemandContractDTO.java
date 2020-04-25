package com.tradeai.demandcontract.dto;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class DemandContractDTO {

	private Integer demandContractId;

	private String clientId;

	private String securityCode;

	private Integer originalQuantity;

	private String accountId;

	private Integer currentQuantity;

	private Double originalRate;

	private Double currentRate;

	private Double originalPrice;

	private Double currentPrice;

	private Double origValue;

	private Double currentValue;

	private Date contractBookingDate;

	private String contractStatus;

	private List<DemandContractActivityDTO> activities; 
	

}
