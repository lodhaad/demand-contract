package com.tradeai.demandcontract.service.state;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradeai.demandcontract.datamodel.DemandActivity;
import com.tradeai.demandcontract.datamodel.DemandActivityStatus;
import com.tradeai.demandcontract.datamodel.DemandContract;
import com.tradeai.demandcontract.dto.DemandContractActivityDTO;
import com.tradeai.demandcontract.dto.DemandContractActivityStatusDTO;
import com.tradeai.demandcontract.dto.DemandContractDTO;
import com.tradeai.demandcontract.repo.DemandActivityRepo;
import com.tradeai.demandcontract.repo.DemandActivityStatusRepo;
import com.tradeai.demandcontract.repo.DemandContractRepo;

@Component("NewSettledState")
public class NewSettledState implements DemandActivityState {

	@Autowired
	private DemandContractRepo contractRepo;

	@Autowired
	private DemandActivityRepo activityRepo;

	@Autowired
	private DemandActivityStatusRepo acivityStatusRepo;

	@Override
	public DemandContractDTO processActivity(DemandContractDTO contract) {
		System.out.println("New Settled");

		ModelMapper mapper = new ModelMapper();

		DemandContract contractDomain = mapper.map(contract, DemandContract.class);
		contractDomain.setContractStatus("S");

		DemandActivity activity = activityRepo.findByDemandContractIdAndActivityTypeAndActivityState(contractDomain.getDemandContractId(), "N", "P");

		activity.setActivityState("S");

		/// create the status
		DemandActivityStatus status = new DemandActivityStatus();
		status.setActivityType("N");
		status.setActivityState("S");
		status.setContractId(contractDomain.getDemandContractId());
		status.setContractActivityId(activity.getDemandContractActivityId());
		status.setContractActivityStatusId(acivityStatusRepo.getMaxDemandActivityStatusId());

		contractDomain = contractRepo.save(contractDomain);

		activity = activityRepo.save(activity);

		status = acivityStatusRepo.save(status);

		DemandContractDTO contractDTO = mapper.map(contractDomain, DemandContractDTO.class);

		DemandContractActivityDTO activityDTO = mapper.map(activity, DemandContractActivityDTO.class);

		DemandContractActivityStatusDTO statusDTO = mapper.map(status, DemandContractActivityStatusDTO.class);

		List<DemandContractActivityStatusDTO> listOfStatus = new ArrayList<DemandContractActivityStatusDTO>();
		listOfStatus.add(statusDTO);
		activityDTO.setStatuses(listOfStatus);

		List<DemandContractActivityDTO> listOfActivities = new ArrayList<DemandContractActivityDTO>();
		listOfActivities.add(activityDTO);

		contractDTO.setActivities(listOfActivities);

		return contractDTO;
	}

}
