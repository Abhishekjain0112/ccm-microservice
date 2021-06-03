package com.ccm.configmaster.configmaster.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ccm.configmaster.configmaster.model.CcmConfiguration;
import com.ccm.configmaster.configmaster.repository.CcmConfigurationrRepo;


@SpringBootTest
class CcmConfigurationServiceImplTest {

	@MockBean
	private CcmConfigurationService ccmConfigurationService;
	
	@MockBean
	private CcmConfigurationrRepo ccmConfigurationrRepo;
	
	
	@Test
	void save(){
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
		config.setStatus(false);	
		
		when(ccmConfigurationrRepo.save(config)).thenReturn(config);
		ccmConfigurationrRepo.save(config);
		verify(ccmConfigurationrRepo).save(config);		
	}
	
	@Test
	void getRecords() {
		
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
		config.setStatus(false);	
		
		List<CcmConfiguration> ccmConfigurationList=new ArrayList<CcmConfiguration>();
		ccmConfigurationList.add(config);
		
		when(ccmConfigurationrRepo.findAll()).thenReturn(ccmConfigurationList);
		ccmConfigurationrRepo.findAll();
		verify(ccmConfigurationrRepo).findAll();
		
	}
	
	@Test
	void getRecordbyField() {
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
		config.setStatus(false);		
		when(ccmConfigurationrRepo.getByFieldCode("101Field")).thenReturn(config);
		ccmConfigurationrRepo.getByFieldCode("101Field");
		verify(ccmConfigurationrRepo).getByFieldCode("101Field");		
	}	

	
	@Test
	void getRecordbyld() {
        CcmConfiguration config = new CcmConfiguration();
        config.setCcmConfigId(1);
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
		when(ccmConfigurationrRepo.getById(1)).thenReturn(config);
		ccmConfigurationrRepo.getById(1);
		verify(ccmConfigurationrRepo).getById(1);		
	}	
	
	
	
	


	
	
	
	
	
}
