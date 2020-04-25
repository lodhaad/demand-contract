package com.tradeai.demandcontract.service.state;

import java.sql.Date;
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

@Component("NewPendingState")
public class NewPendingState implements DemandActivityState {
	
	@Autowired
	private DemandContractRepo contractRepo;

	@Autowired
	private DemandActivityRepo activityRepo;

	@Autowired
	private DemandActivityStatusRepo acivityStatusRepo;

	@Override
	public DemandContractDTO processActivity(DemandContractDTO contract) {
		/// get a new contract number
		Integer contractId = contractRepo.getMaxContractId();

		if (contractId == null) {
			/// first record
			contractId = 1;
		}

		contract.setDemandContractId(contractId);

		ModelMapper mapper = new ModelMapper();
		DemandContract contractData = mapper.map(contract, DemandContract.class);
		contractData.setContractStatus("P");
		contractData.setContractBookingDate(new Date(System.currentTimeMillis()));

		/// create the activity
		DemandActivity activity = new DemandActivity();
		activity.setDemandContractId(contractId);
		activity.setDemandContractActivityId(new Integer(1));
		activity.setActivityType("N");
		activity.setActivityState("P");
		activity.setActivityPrice(contract.getOriginalPrice());
		activity.setActivityQuantity(contract.getOriginalQuantity());
		activity.setActivityRate(contract.getOriginalRate());

		/// create the status
		DemandActivityStatus status = new DemandActivityStatus();
		status.setActivityType("N");
		status.setActivityState("P");
		status.setContractId(contractId);
		status.setContractActivityId(new Integer(1));
		status.setContractActivityStatusId(new Integer(1));

		// insert contract
		DemandContract contractFromDatabase = contractRepo.save(contractData);

		// insert activity
		DemandActivity activityFromDb = activityRepo.save(activity);

		/// insert status
		DemandActivityStatus statusFromDb = acivityStatusRepo.save(status);

		DemandContractDTO contractDTO = mapper.map(contractFromDatabase, DemandContractDTO.class);

		DemandContractActivityDTO activityDTO = mapper.map(activityFromDb, DemandContractActivityDTO.class);

		DemandContractActivityStatusDTO statusDTO = mapper.map(statusFromDb, DemandContractActivityStatusDTO.class);

		List<DemandContractActivityStatusDTO> listOfStatus = new ArrayList<DemandContractActivityStatusDTO>();
		listOfStatus.add(statusDTO);
		activityDTO.setStatuses(listOfStatus);

		List<DemandContractActivityDTO> listOfActivities = new ArrayList<DemandContractActivityDTO>();
		listOfActivities.add(activityDTO);

		contractDTO.setActivities(listOfActivities);

		return contractDTO;

	}

}
