package com.ccm.configmaster.configmaster.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccm.configmaster.configmaster.dto.CcmConfigurationDTO;
import com.ccm.configmaster.configmaster.service.CcmConfigurationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class CcmConfigurationController {

	@Autowired
	private CcmConfigurationService configurationService;
	
	
	@GetMapping("/getid/{id}")
	public CcmConfigurationDTO getConfigurationById(@PathVariable int id){
		log.info("Get by Field Id Url Hit: /getid/id ");
		return configurationService.getConfigurationById(id);
	}

	@GetMapping("/get/{fieldName}")
	public CcmConfigurationDTO getConfigurationByFieldName(@PathVariable String fieldName){
		log.info("Get by Field Name Url Hit: /getid/fieldName ");
		return configurationService.getConfigurationByFieldCode(fieldName);
	}	
	
	@GetMapping("/get")
	public List<CcmConfigurationDTO> getConfigurations(){
		log.info("Get All Records url: /get");
		return configurationService.getAllConfigurations();
	}
		
	
	@PostMapping(value = "/add" , consumes = "application/json", produces = "application/json")
	public CcmConfigurationDTO addConfiguration(@RequestBody CcmConfigurationDTO configuration ) {
		log.info("Post request to add the the record is hit URL: /add");
		return configurationService.addConfiguration(configuration);
	}
	
	

	
	
	
}
