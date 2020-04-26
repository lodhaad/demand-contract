package com.tradeai.demandcontract.datamodel;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "demand_contract_activity_state", schema = "demand_contract")
@IdClass(StatusCompositeKey.class)

public class DemandActivityStatus {
	@Id
	@Column (name = "demand_contract_activity_state_id")
	private Integer contractActivityStatusId;

	@Id
	@Column (name = "demand_contract_id")
	private Integer contractId;

	@Id
	@Column (name = "demand_contract_activity_id")
	private Integer contractActivityId;

	@Column (name = "demand_contract_activity_type")
	private String activityType;

	@Column (name = "demand_contract_activity_state")
	private String activityState;

	@Column (name = "demand_activity_state_date")
	private Date activityStateDate;

	@Column (name = "demand_contract_activity_state_timestamp")
	private LocalDateTime activityStateTimestamp;

}
