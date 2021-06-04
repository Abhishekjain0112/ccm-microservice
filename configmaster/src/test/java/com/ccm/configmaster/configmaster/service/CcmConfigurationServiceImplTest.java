package com.ccm.configmaster.configmaster.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ccm.configmaster.configmaster.dto.CcmConfigurationDTO;
import com.ccm.configmaster.configmaster.exception.DataNotFoundException;
import com.ccm.configmaster.configmaster.model.CcmConfiguration;
import com.ccm.configmaster.configmaster.repository.CcmConfigurationrRepo;


@SpringBootTest
class CcmConfigurationServiceImplTest {

	//@MockBean
	//private CcmConfigurationServiceImpl ccmConfigurationService;
	
	 @Autowired
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
			config.setFieldValue("Field Value");
			config.setAffectedModules("Affected Module");
			config.setReason("reason");
			config.setStatus(false);		
	        
		when(ccmConfigurationrRepo.save(config)).thenReturn(config);

		 CcmConfigurationDTO configDto =ccmConfigurationService.getDtoFromConfig(config);
		
		
		CcmConfiguration configResult =ccmConfigurationService.getConfigFromDto(ccmConfigurationService.addConfiguration(configDto));
		
		assertEquals(configDto.getFieldCode().toString(),configResult.getFieldCode().toString());
		
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
		config.setFieldValue("Field Value");
		config.setAffectedModules("Affected Module");
		config.setReason("reason");
		config.setStatus(false);	
	
		List<CcmConfiguration> ccmConfigurationList=new ArrayList<CcmConfiguration>();
		ccmConfigurationList.add(config);
		
		when(ccmConfigurationrRepo.findAll()).thenReturn(ccmConfigurationList);
		
		List<CcmConfigurationDTO> ccmConfigurationDAOListResult=ccmConfigurationService.getAllConfigurations();
		
		
		assertEquals(1, ccmConfigurationDAOListResult.size());
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
		config.setFieldValue("Field Value");
		config.setAffectedModules("Affected Module");
		config.setReason("reason");
		config.setStatus(false);		
		when(ccmConfigurationrRepo.getByFieldCode("101Field")).thenReturn(config);
		ccmConfigurationrRepo.getByFieldCode("101Field");
		verify(ccmConfigurationrRepo).getByFieldCode("101Field");	

		CcmConfigurationDTO result= ccmConfigurationService.getConfigurationByFieldCode("101Field");		
		assertEquals(config.getFieldCode().toString(),result.getFieldCode().toString());
		
		
		assertEquals(config, ccmConfigurationrRepo.getByFieldCode("101Field"));
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
		config.setFieldValue("Field Value");
		config.setAffectedModules("Affected Module");
		config.setReason("reason");
		config.setStatus(false);		
		Optional<CcmConfiguration> data =Optional.of(config);
		when(ccmConfigurationrRepo.findById(1)).thenReturn(data);
		
		
		CcmConfigurationDTO result= ccmConfigurationService.getConfigurationById(1);		
		assertEquals(data.get().getFieldCode().toString(),result.getFieldCode().toString());

		
	}	
	
	
   @Test
   void testFindByIdException() {
	   int id=1;
	   assertThrows(DataNotFoundException.class	,()->ccmConfigurationService.getConfigurationById(id),"Data with id ["+id+"] Found");
   }
	
	


	
	
	
	
	
}
