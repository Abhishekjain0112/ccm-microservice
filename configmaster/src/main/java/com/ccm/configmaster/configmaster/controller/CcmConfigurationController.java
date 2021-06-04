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
import com.ccm.configmaster.configmaster.model.CcmConfiguration;
import com.ccm.configmaster.configmaster.service.CcmConfigurationService;

@RestController
@RequestMapping("/api")
public class CcmConfigurationController {

	@Autowired
	private CcmConfigurationService configurationService;
	
	
	@GetMapping("/getid/{id}")
	public CcmConfigurationDTO getConfigurationById(@PathVariable int id){
		return configurationService.getConfigurationById(id);
	}

	@GetMapping("/get/{fieldName}")
	public CcmConfigurationDTO getConfigurationById(@PathVariable String fieldName){
		return configurationService.getConfigurationByFieldCode(fieldName);
	}	
	
	@GetMapping("/get")
	public List<CcmConfigurationDTO> getConfigurations(){
		return configurationService.getAllConfigurations();
	}
		
	@PostMapping(value = "/add" , consumes = "application/json", produces = "application/json")
	public CcmConfigurationDTO addConfiguration(@RequestBody CcmConfigurationDTO configuration ) {
		return configurationService.addConfiguration(configuration);
	}
	
	

	
	
	
}
