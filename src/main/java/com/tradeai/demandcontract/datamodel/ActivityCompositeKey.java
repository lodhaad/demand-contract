package com.tradeai.demandcontract.datamodel;

import java.io.Serializable;

public class ActivityCompositeKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer demandContractId;
	private Integer demandContractActivityId;

	public ActivityCompositeKey() {

	}

	public ActivityCompositeKey(Integer demandContractId, Integer demandContractActivityId) {
		super();
		this.demandContractId = demandContractId;
		this.demandContractActivityId = demandContractActivityId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((demandContractActivityId == null) ? 0 : demandContractActivityId.hashCode());
		result = prime * result + ((demandContractId == null) ? 0 : demandContractId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityCompositeKey other = (ActivityCompositeKey) obj;
		if (demandContractActivityId == null) {
			if (other.demandContractActivityId != null)
				return false;
		} else if (!demandContractActivityId.equals(other.demandContractActivityId))
			return false;
		if (demandContractId == null) {
			if (other.demandContractId != null)
				return false;
		} else if (!demandContractId.equals(other.demandContractId))
			return false;
		return true;
	}

}
