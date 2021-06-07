package com.ccm.configmaster.configmaster.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.ccm.configmaster.configmaster.dto.CcmConfigurationDTO;
import com.ccm.configmaster.configmaster.service.CcmConfigurationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class CcmConfigurationControllerTest {

	
	@Autowired
	private MockMvc mock;
	
	@MockBean
	private CcmConfigurationService configurationService;
	
	
	@Autowired
	private CcmConfigurationController ccmConfigurationController;
	
	@Test
	void testSaveConfiguration() throws Exception {		
	       CcmConfigurationDTO configDto = new CcmConfigurationDTO();
	       configDto.setCcmConfigId(1);
	        configDto.setFieldCode("101Field");
	        configDto.setFieldName("FieldName");
	        configDto.setFieldDescription("Field Description");
	        configDto.setRequired(true);
	        configDto.setDataFormat("Data formate");
	        configDto.setFieldDefaultValue("field default Value");
	        configDto.setMaximumValue("max 5000");
	        configDto.setMinumumValue("min value 10");
	        configDto.setFieldValue("Field Value");
	        configDto.setAffectedModules("Affected Module");
	        configDto.setReason("reason");
	        configDto.setStatus(false);	
	
							
			
						
			 when(configurationService.addConfiguration(configDto)).thenReturn(configDto);
		    
			   assertEquals(configDto,ccmConfigurationController.addConfiguration(configDto) ); 
			 
	}
	

	
	@Test
	void testGetConfigurationById() throws Exception {		
	       CcmConfigurationDTO configDto = new CcmConfigurationDTO();
	       configDto.setCcmConfigId(1);
	        configDto.setFieldCode("101Field");
	        configDto.setFieldName("FieldName");
	        configDto.setFieldDescription("Field Description");
	        configDto.setRequired(true);
	        configDto.setDataFormat("Data formate");
	        configDto.setFieldDefaultValue("field default Value");
	        configDto.setMaximumValue("max 5000");
	        configDto.setMinumumValue("min value 10");
	        configDto.setFieldValue("Field Value");
	        configDto.setAffectedModules("Affected Module");
	        configDto.setReason("reason");
	        configDto.setStatus(false);		
		
			
			 when(configurationService.getConfigurationById(1)).thenReturn(configDto);
			 assertEquals(configDto,ccmConfigurationController.getConfigurationById(1) ); 
		
	}
		
	@Test
	void testGetConfigurationByFieldCode() throws Exception {		
	       CcmConfigurationDTO configDto = new CcmConfigurationDTO();
	       configDto.setCcmConfigId(1);
	        configDto.setFieldCode("101Field");
	        configDto.setFieldName("FieldName");
	        configDto.setFieldDescription("Field Description");
	        configDto.setRequired(true);
	        configDto.setDataFormat("Data formate");
	        configDto.setFieldDefaultValue("field default Value");
	        configDto.setMaximumValue("max 5000");
	        configDto.setMinumumValue("min value 10");
	        configDto.setFieldValue("Field Value");
	        configDto.setAffectedModules("Affected Module");
	        configDto.setReason("reason");
	        configDto.setStatus(false);			
			 when(configurationService.getConfigurationByFieldCode("101Field")).thenReturn(configDto);
			 
			 assertEquals(configDto,ccmConfigurationController.getConfigurationByFieldName("101Field")); 
				
	
	}
			

	
	@Test
	void testGetAllConfigurations() throws Exception {		


	       CcmConfigurationDTO configDto = new CcmConfigurationDTO();
	       configDto.setCcmConfigId(1);
	        configDto.setFieldCode("101Field");
	        configDto.setFieldName("FieldName");
	        configDto.setFieldDescription("Field Description");
	        configDto.setRequired(true);
	        configDto.setDataFormat("Data formate");
	        configDto.setFieldDefaultValue("field default Value");
	        configDto.setMaximumValue("max 5000");
	        configDto.setMinumumValue("min value 10");
	        configDto.setFieldValue("Field Value");
	        configDto.setAffectedModules("Affected Module");
	        configDto.setReason("reason");
	        configDto.setStatus(false);	
			
			List<CcmConfigurationDTO> ccmConfigurationList=new ArrayList<CcmConfigurationDTO>();
			ccmConfigurationList.add(configDto);		
			 when(configurationService.getAllConfigurations()).thenReturn(ccmConfigurationList);		 
			
			 assertEquals(ccmConfigurationList,ccmConfigurationController.getConfigurations()); 
				
			 
	}
			
	
	
	// JsonMapper
	String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
	
	
	
}
