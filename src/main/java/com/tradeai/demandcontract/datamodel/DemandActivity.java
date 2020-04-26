package com.tradeai.demandcontract.datamodel;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
import javax.persistence.Id;

@Data
@Entity
@Table (name = "demand_contract_activity", schema = "demand_contract")
@IdClass(ActivityCompositeKey.class)
public class DemandActivity {

	@Id
	@Column (name = "demand_contract_activity_id")
	private Integer demandContractActivityId;

	@Id
	@Column (name = "demand_contract_id")
	private Integer demandContractId;

	@Column (name = "demand_contract_activity_type")
	private String activityType;

	@Column (name = "demand_contract_activity_price")
	private Double activityPrice;

	@Column (name = "demand_contract_activity_rate")
	private Double activityRate;

	@Column (name = "demand_contract_activity_quantity")
	private Integer activityQuantity;
	
	@Column (name = "demand_contract_activity_state")
	private String activityState;

	@Column (name = "demand_contract_activity_date")
	private Date activityDate;

	@Column (name = "demand_contract_activity_creation_timestamp")
	private LocalDateTime activityCreation;

	@Column (name = "demand_contract_activity_updation_timestamp")
	private LocalDateTime activityUpdation;

}
