package com.tradeai.demandcontract.repo;

import org.springframework.data.repository.CrudRepository;

import com.tradeai.demandcontract.datamodel.DemandActivityStatus;

public interface DemandActivityStatusRepo extends CrudRepository<DemandActivityStatus, Integer> {

}
