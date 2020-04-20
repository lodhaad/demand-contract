package com.tradeai.demandcontract.repo;

import org.springframework.data.repository.CrudRepository;

import com.tradeai.demandcontract.datamodel.DemandContract;

public interface DemandContractRepo extends CrudRepository<DemandContract, Integer> {

}
