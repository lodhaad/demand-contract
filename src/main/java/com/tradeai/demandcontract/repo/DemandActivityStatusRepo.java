package com.tradeai.demandcontract.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tradeai.demandcontract.datamodel.DemandActivityStatus;

public interface DemandActivityStatusRepo extends CrudRepository<DemandActivityStatus, Integer> {

	List<DemandActivityStatus> findByContractIdAndContractActivityId(Integer contractId, Integer contractActivityId);

	@Query("select max(contractActivityStatusId) + 1 from DemandActivityStatus")
	public Integer getMaxDemandActivityStatusId();

}
