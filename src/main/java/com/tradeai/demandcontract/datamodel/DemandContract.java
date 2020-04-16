package com.tradeai.demandcontract.datamodel;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "supply_contract", schema = "supply")


public class DemandContract {
	
	@Id
	@Column (name = "supply_contract_id")
	private Integer demandContractId;
	
	
	@Column (name = "supplier_id")
	private String clientId;
	
	@Column (name = "supply_sec_code")
	private String securityCode;
	
	@Column (name = "supply_orig_qty")
	private Integer originalQuantity;
	
	@Column (name = "acct_id")
	private String accountId;
	
	@Column (name = "supply_current_qty")
	private Integer currentQuantity;
	
	@Column (name = "supply_orig_rate")
	private Double originalRate;
	
	@Column (name = "supply_current_rate")
	private Double currentRate;
	
	@Column (name = "supply_orig_price")
	private Double originalPrice;
	
	@Column (name = "supply_current_price")
	private Double currentPrice;
	@Column (name = "supply_current_price")
	private Double origValue;
	
	@Column (name = "supply_current_price")
	private Double currentValue;
	
	@Column (name = "supply_contract_date")
	private Date contractBookingDate;
	

	@Column (name = "contract_status")
	private String contractStatus;
	
	@Column (name = "activity_type")
	private String activityType;
	

}
