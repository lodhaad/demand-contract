package com.tradeai.demandcontract.datamodel;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "demand_contract", schema = "demand_contract")
@Data
public class DemandContract {

	@Id
	@Column(name = "demand_contract_id")
	private Integer demandContractId;

	@Column(name = "client_id")
	private String clientId;

	@Column(name = "acct_id")
	private String accountId;

	@Column(name = "sec_code")
	private String securityCode;

	@Column(name = "demand_orig_qty")
	private Integer originalQuantity;

	@Column(name = "demand_current_qty")
	private Integer currentQuantity;

	@Column(name = "demand_orig_rate")
	private Double originalRate;

	@Column(name = "demand_current_rate")
	private Double currentRate;

	@Column(name = "demand_orig_price")
	private Double originalPrice;

	@Column(name = "demand_current_price")
	private Double currentPrice;
	
	@Column(name = "demand_orig_value")
	private Double origValue;

	@Column(name = "demand_current_value")
	private Double currentValue;

	@Column(name = "demand_contract_date")
	private Date contractBookingDate;

	@Column(name = "contract_status")
	private String contractStatus;
	
	@Column(name = "latest_activity_type")
	private String latestActivity;

}
