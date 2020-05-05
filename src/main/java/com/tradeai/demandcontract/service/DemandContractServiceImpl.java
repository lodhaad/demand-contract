package com.tradeai.demandcontract.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tradeai.demandcontract.datamodel.DemandActivity;
import com.tradeai.demandcontract.datamodel.DemandActivityStatus;
import com.tradeai.demandcontract.datamodel.DemandContract;
import com.tradeai.demandcontract.dto.DemandContractActivityDTO;
import com.tradeai.demandcontract.dto.DemandContractActivityStatusDTO;
import com.tradeai.demandcontract.dto.DemandContractDTO;
import com.tradeai.demandcontract.input.ClientContractRequest;
import com.tradeai.demandcontract.repo.DemandActivityRepo;
import com.tradeai.demandcontract.repo.DemandActivityStatusRepo;
import com.tradeai.demandcontract.repo.DemandContractRepo;
import com.tradeai.demandcontract.service.processing.DemandActivityFactory;
import com.tradeai.demandcontract.service.processing.DemandActivityProcess;

@Service

public class DemandContractServiceImpl implements DemandContractService {
	
	@Autowired
	private DemandContractRepo repository;

	@Autowired
	private DemandActivityRepo activityRepository;

	@Autowired
	private DemandActivityStatusRepo acivityStatusRepository;

	@Autowired
	@Qualifier("ActivityFactory")
	private DemandActivityFactory factory;
	

	@Override
	public DemandContractDTO processContractActivity(ClientContractRequest contractRequest, String activityType, String activityStatus) throws Exception{
		DemandActivityProcess activityProcess =  factory.getActivityType(activityType);
		
		DemandContractDTO demandContractDTO ;
		
		if("S".equals(activityStatus)) {
			demandContractDTO = getContractByContractId(contractRequest.getContractId());
		} else {
			demandContractDTO = mapNewContractRequest(contractRequest);
		}
		
		DemandContractDTO returnedcontractDTO = activityProcess.processActivity(demandContractDTO, activityStatus);
		return returnedcontractDTO;
	}
	

	@Override
	public DemandContractDTO getContractByContractId(Integer contractId) {
		Optional<DemandContract> contract = repository.findById(contractId);
		DemandContract contractForQuery = contract.get();
		DemandContractDTO contractDto = convert(contractForQuery);
		return contractDto;
	}


	private DemandContractDTO convert(DemandContract contractModel) {

		List<DemandActivity> activities = activityRepository.findByDemandContractId(contractModel.getDemandContractId());

		List<DemandContractActivityDTO> dtos = new ArrayList<>();

		for (DemandActivity activity : activities) {

			List<DemandContractActivityStatusDTO> statuses = new ArrayList<>();

			List<DemandActivityStatus> dbstatus = acivityStatusRepository.findByContractIdAndContractActivityId(
					activity.getDemandContractId(), activity.getDemandContractActivityId());

			for (DemandActivityStatus status : dbstatus) {

				DemandContractActivityStatusDTO statusDTO = new DemandContractActivityStatusDTO();
				statusDTO.setContractActivityId(status.getContractActivityId());
				statusDTO.setContractId(status.getContractId());
				statusDTO.setContractActivityStatusId(status.getContractActivityStatusId());
				statusDTO.setActivityType(status.getActivityType());
				statusDTO.setActivityState(status.getActivityState());

				statuses.add(statusDTO);

			}

			DemandContractActivityDTO activityDTO = new DemandContractActivityDTO();

			activityDTO.setDemandContractActivityId(activity.getDemandContractActivityId());
			activityDTO.setActivityState(activity.getActivityState());
			activityDTO.setActivityType(activity.getActivityType());
			activityDTO.setContractId(activity.getDemandContractId());
			activityDTO.setActivityPrice(activity.getActivityPrice());
			activityDTO.setActivityQuantity(activity.getActivityQuantity());
			activityDTO.setActivityRate(activity.getActivityRate());

			activityDTO.setStatuses(statuses);

			dtos.add(activityDTO);

		}

		DemandContractDTO contractDTO = new DemandContractDTO();
		contractDTO.setAccountId(contractModel.getAccountId());
		contractDTO.setDemandContractId(contractModel.getDemandContractId());
		contractDTO.setOriginalPrice(contractModel.getOriginalPrice());
		contractDTO.setOriginalQuantity(contractModel.getOriginalQuantity());
		contractDTO.setOriginalRate(contractModel.getOriginalRate());
		contractDTO.setSecurityCode(contractModel.getSecurityCode());
		contractDTO.setCurrentPrice(contractModel.getCurrentPrice());
		contractDTO.setCurrentQuantity(contractModel.getCurrentQuantity());
		contractDTO.setCurrentRate(contractModel.getCurrentRate());
		contractDTO.setContractStatus(contractModel.getContractStatus());
		contractDTO.setActivities(dtos);
		contractDTO.setClientId(contractModel.getClientId());
		contractDTO.setContractBookingDate(contractModel.getContractBookingDate());

		return contractDTO;

	}


	
}
