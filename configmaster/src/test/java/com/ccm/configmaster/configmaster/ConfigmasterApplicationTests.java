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
			String jsonCcmConfiguration = this.mapToJson(config);			
			 when(configurationService.addConfiguration(config)).thenReturn(config);
			 MvcResult mvcResult = mock.perform(post("/api/add").contentType("application/json")
					      		.content(jsonCcmConfiguration))
						        .andReturn();
			 assertEquals(200, mvcResult.getResponse().getStatus());		
	}
	
	// JsonMapper
	String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}	

}
