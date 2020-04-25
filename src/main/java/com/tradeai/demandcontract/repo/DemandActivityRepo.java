package com.tradeai.demandcontract.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tradeai.demandcontract.datamodel.DemandActivity;

public interface DemandActivityRepo extends CrudRepository<DemandActivity, Integer> {

	public List<DemandActivity> findByDemandContractId(Integer demandContractId);

	@Query("select max(demandContractActivityId) + 1 from DemandActivity where demandContractId = (:contractId)")
	public Integer getMaxActivityForContract(@Param("contractId") Integer contractId);

	public DemandActivity findByDemandContractIdAndActivityTypeAndActivityState(Integer contractId, String activityType, String activityStatus);
}
