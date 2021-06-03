package com.ccm.configmaster.configmaster.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccm.configmaster.configmaster.model.CcmConfiguration;
import com.ccm.configmaster.configmaster.service.CcmConfigurationService;

@RestController
@RequestMapping("/api")
public class CcmConfigurationController {

	@Autowired
	private CcmConfigurationService configurationService;
	
	
	@GetMapping("/getid/{id}")
	public CcmConfiguration getConfigurationById(@PathVariable int id){
		return configurationService.getConfigurationById(id);
	}

	@GetMapping("/get/{fieldName}")
	public CcmConfiguration getConfigurationById(@PathVariable String fieldName){
		return configurationService.getConfigurationByFieldCode(fieldName);
	}	
	
	@GetMapping("/get")
	public List<CcmConfiguration> getConfigurations(){
		return configurationService.getAllConfigurations();
	}
		
	@PostMapping(value = "/add" , consumes = "application/json", produces = "application/json")
	public CcmConfiguration addConfiguration(@RequestBody CcmConfiguration configuration ) {
		
	/*	CcmConfiguration config = new CcmConfiguration();
		
		config.setFieldCode("101Field");
		config.setFieldName("FieldName");
		config.setFieldDescription("Field Description");
		config.setRequired(true);
		config.setDataFormat("Data formate");
		config.setFieldDefaultValue("field default Value");
		config.setMaximumValue("max 5000");
		config.setMinumumValue("min value 10");
		config.setField_value("Field Value");
		config.setAffected_modules("Affected Module");
		config.setReason("reason");
		config.setStatus(false);
		*/
		
		return configurationService.addConfiguration(configuration);
	}
	
	

	
/*
 
 Json Object 
 
 {
  "ccmConfigId": 3,
  "fieldCode": "101Field",
  "fieldName": "FieldName",
  "fieldDescription": "Field Description",
  "required": true,
  "dataFormat": "Data formate",
  "fieldDefaultValue": "field default Value",
  "maximumValue": "max 5000",
  "minumumValue": "min value 10",
  "field_value": "Field Value",
  "affected_modules": "Affected Module",
  "reason": "reason",
  "createdOn": "2021-06-01T07:18:55.020+00:00",
  "updatedOn": "2021-06-01T07:18:55.020+00:00",
  "status": false
}
 
{
  "fieldCode": "101Field",
  "fieldName": "FieldName",
  "fieldDescription": "Field Description",
  "required": true,
  "dataFormat": "Data formate",
  "fieldDefaultValue": "field default Value",
  "maximumValue": "max 5000",
  "minumumValue": "min value 10",
  "field_value": "Field Value",
  "affected_modules": "Affected Module",
  "reason": "reason",
  "status": false
} 
 
CcmConfiguration config = new CcmConfiguration();		
		config.setFieldCode("101Field");
		config.setFieldName("FieldName");
		config.setFieldDescription("Field Description");
		config.setRequired(true);
		config.setDataFormat("Data formate");
		config.setFieldDefaultValue("field default Value");
		config.setMaximumValue("max 5000");
		config.setMinumumValue("min value 10");
		config.setField_value("Field Value");
		config.setAffected_modules("Affected Module");
		config.setReason("reason");
		config.setCreatedOn(Timestamp.from(Instant.now()));
		config.setUpdatedOn(Timestamp.from(Instant.now()));
		config.setStatus(false); 
 */	
	
}
