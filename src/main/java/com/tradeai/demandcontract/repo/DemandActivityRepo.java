package com.tradeai.demandcontract.repo;

import org.springframework.data.repository.CrudRepository;

import com.tradeai.demandcontract.datamodel.DemandActivity;

public interface DemandActivityRepo extends CrudRepository<DemandActivity, Integer> {

}
