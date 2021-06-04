package com.ccm.configmaster.configmaster;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.ccm.configmaster.configmaster.dto.CcmConfigurationDTO;
import com.ccm.configmaster.configmaster.model.CcmConfiguration;
import com.ccm.configmaster.configmaster.service.CcmConfigurationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ConfigmasterApplicationTests {

	
	
	@Autowired
	private MockMvc mock;
	
	@MockBean
	private CcmConfigurationService configurationService;
	
	
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
							
			
			String jsonCcmConfiguration = this.mapToJson(config);			
			 when(configurationService.addConfiguration(configDto)).thenReturn(config);
			 MvcResult mvcResult = mock.perform(post("/api/add").contentType("application/json")
					      		.content(jsonCcmConfiguration))
						        .andReturn();
			 assertEquals(200, mvcResult.getResponse().getStatus());		
	}
	

	
	@Test
	void testGetConfigurationById() throws Exception {		
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
			
			String jsonCcmConfiguration = this.mapToJson(config);
			
			 when(configurationService.getConfigurationById(1)).thenReturn(config);
			 
			 MvcResult mvcResult = mock.perform(get("/api/getid/"+1).contentType("application/json")
					      		.content(jsonCcmConfiguration))
						        .andReturn();		 
			 assertEquals(200, mvcResult.getResponse().getStatus());	
			 assertEquals(true, mvcResult.getResponse().getContentAsString().contains("101Field") );
	}
		
	@Test
	void testGetConfigurationByFieldCode() throws Exception {		
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
			String jsonCcmConfiguration = this.mapToJson(config);
			
			 when(configurationService.getConfigurationByFieldCode("101Field")).thenReturn(config);
			 
			 MvcResult mvcResult = mock.perform(get("/api/get/"+"101Field").contentType("application/json")
					      		.content(jsonCcmConfiguration))
						        .andReturn();		 
			 assertEquals(200, mvcResult.getResponse().getStatus());	
			 assertEquals(true, mvcResult.getResponse().getContentAsString().contains("FieldName") );
	}
			

	
	@Test
	void testGetAllConfigurations() throws Exception {		
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
			
			List<CcmConfiguration> ccmConfigurationList=new ArrayList<CcmConfiguration>();
			ccmConfigurationList.add(config);		
			 when(configurationService.getAllConfigurations()).thenReturn(ccmConfigurationList);		 
			 MvcResult mvcResult = mock.perform(get("/api/get")).andReturn();		 
			 assertEquals(200, mvcResult.getResponse().getStatus());	
			 
	}
			
	
	
	// JsonMapper
	String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}	

}
