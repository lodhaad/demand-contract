package com.tradeai.demandcontract.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientContractRequest {
	private String clientId;
	private String securityCode;
	private Integer askedQuantity;
	private Double askedRate;
	private Double askedPrice;
}
