package com.tradeai.demandcontract.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradeai.demandcontract.dto.DemandContractActivityDTO;
import com.tradeai.demandcontract.dto.DemandContractActivityStatusDTO;
import com.tradeai.demandcontract.dto.DemandContractDTO;
import com.tradeai.demandcontract.input.ClientContractRequest;
import com.tradeai.demandcontract.output.DemandContractActivityResponse;
import com.tradeai.demandcontract.output.DemandContractActivityStatusResponse;
import com.tradeai.demandcontract.output.DemandContractResponse;
import com.tradeai.demandcontract.service.DemandContractService;

@RestController
@RequestMapping("/demand-contract")
public class DemandContractController {
	
	@Autowired 
	DemandContractService service;
	
	
	
	public void health() {
		
	}
	
	@GetMapping(path = "/{contractId}")
	public ResponseEntity<DemandContractResponse> getContract(@PathVariable String contractId) {
		
		DemandContractDTO contractDTO = service.getContractByContractId(Integer.parseInt(contractId));
		
		DemandContractResponse clientContractOutput = mapContractDTOToResponse(contractDTO);
		
		return new ResponseEntity<DemandContractResponse>(clientContractOutput, HttpStatus.OK);
		
	}
	

	@PostMapping
	public ResponseEntity<DemandContractResponse>  addContract(@RequestBody ClientContractRequest contractRequest) throws Exception { 
		
		DemandContractDTO contractDTO  = service.processContractActivity(contractRequest,"N", "P");
		
		DemandContractResponse clientContractOutput = mapContractDTOToResponse(contractDTO);
		
		return new ResponseEntity<DemandContractResponse>(clientContractOutput, HttpStatus.OK);
		
	}

	@PutMapping
	public ResponseEntity<DemandContractResponse>  settleContract(@RequestBody ClientContractRequest contractRequest) throws Exception { 
		
		DemandContractDTO contractDTO  = service.processContractActivity(contractRequest,"N", "S");
		
		DemandContractResponse clientContractOutput = mapContractDTOToResponse(contractDTO);
		
		return new ResponseEntity<DemandContractResponse>(clientContractOutput, HttpStatus.OK);
		
	}

	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public static DemandContractResponse mapContractDTOToResponse(DemandContractDTO dto) {

		DemandContractResponse response = new DemandContractResponse();

		List<DemandContractActivityDTO> activities = dto.getActivities();

		List<DemandContractActivityResponse> activitiesRes = new ArrayList<>();

		List<DemandContractActivityStatusResponse> statusRes = new ArrayList<>();

		activities.forEach(element -> {

			DemandContractActivityResponse activityResponseElement = new DemandContractActivityResponse();
			
			activityResponseElement.setContractId(element.getContractId());
			activityResponseElement.setDemandContractActivityId(element.getDemandContractActivityId());
			activityResponseElement.setActivityPrice(element.getActivityPrice());
			activityResponseElement.setActivityQuantity(element.getActivityQuantity());
			activityResponseElement.setActivityRate(element.getActivityRate());
			activityResponseElement.setActivityType(element.getActivityType());
			activityResponseElement.setActivityState(element.getActivityState());

			List<DemandContractActivityStatusDTO> statusdto = element.getStatuses();

			statusdto.forEach(status -> {

				DemandContractActivityStatusResponse statusActivityRes = new DemandContractActivityStatusResponse();
				statusActivityRes.setContractActivityId(status.getContractActivityId());
				statusActivityRes.setContractId(status.getContractId());
				statusActivityRes.setActivityType(status.getActivityType());
				statusActivityRes.setActivityState(status.getActivityState());
				statusActivityRes.setContractActivityStatusId(status.getContractActivityStatusId());

				statusRes.add(statusActivityRes);

			});

			activityResponseElement.setStatuses(statusRes);

			activitiesRes.add(activityResponseElement);

		});

		response.setDemandContractId(dto.getDemandContractId());
		response.setSecurityCode(dto.getSecurityCode());
		response.setContractStatus(dto.getContractStatus());
		response.setCurrentQuantity(dto.getOriginalQuantity());
		response.setCurrentPrice(dto.getCurrentPrice());
		response.setCurrentRate(dto.getCurrentRate());
		response.setOriginalPrice(dto.getOriginalPrice());
		response.setOriginalQuantity(dto.getOriginalQuantity());
		response.setOriginalRate(dto.getOriginalRate());
	
		response.setClientId(dto.getClientId());

		response.setActivities(activitiesRes);

		return response;
	}
	
	
}
