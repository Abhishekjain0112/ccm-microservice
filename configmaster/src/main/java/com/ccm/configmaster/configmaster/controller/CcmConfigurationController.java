package com.ccm.configmaster.configmaster.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ccm.configmaster.configmaster.model.CcmConfiguration;
import com.ccm.configmaster.configmaster.service.CcmConfigurationService;

@RestController
public class CcmConfigurationController {

	@Autowired
	private CcmConfigurationService configurationService;
	
	
	@GetMapping("/get/{fieldCode}")
	public CcmConfiguration getConfigurationById(@PathVariable int fieldCode){
		return configurationService.getConfigurationById(fieldCode);
	}
		
	@GetMapping("/get")
	public List<CcmConfiguration> getConfigurations(){
		return configurationService.getAllConfigurations();
	}
		
	@GetMapping("/save1")
	public CcmConfiguration addConfiguration() {
		
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
		
		
		return configurationService.addConfiguration(config);
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
