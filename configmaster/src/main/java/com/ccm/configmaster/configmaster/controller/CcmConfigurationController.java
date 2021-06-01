package com.ccm.configmaster.configmaster.controller;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ccm.configmaster.configmaster.model.CcmConfiguration;
import com.ccm.configmaster.configmaster.service.CcmConfigurationService;

@RestController
public class CcmConfigurationController {

	@Autowired
	private CcmConfigurationService configurationService;
	
	
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
	
	
	
}
