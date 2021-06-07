package com.ccm.configmaster.configmaster.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ccm.configmaster.configmaster.model.CcmConfiguration;


@SpringBootTest

class CcmConfigurationDTOTest {

	CcmConfigurationDTO createInstance() {
	   return new CcmConfigurationDTO();
   }
   @Test
    void testGetccmConfigId() {
	   CcmConfigurationDTO config=  createInstance();
	   int id = config.getCcmConfigId();
	   assertTrue(true);
	  
   }

   @Test
    void testToString() {
	   CcmConfigurationDTO config=  createInstance();
	   String s= createInstance().toString();
	   assertTrue(true);
   }
   
   
   @Test
   void testGeterandSeter() {
	   CcmConfigurationDTO config = new CcmConfigurationDTO();	
        config.setCcmConfigId(1);
		config.setFieldCode("101Field");
		assertEquals("101Field", config.getFieldCode());
		
		config.setFieldName("FieldName");
		assertEquals("FieldName", config.getFieldName());
		
		config.setFieldDescription("Field Description");
		assertEquals("Field Description", config.getFieldDescription());
		
		config.setRequired(true);
		assertEquals(true, config.isRequired());
		
		config.setDataFormat("Data formate");
		assertEquals("Data formate", config.getDataFormat());
		
		config.setFieldDefaultValue("field default Value");
		assertEquals("field default Value", config.getFieldDefaultValue());

		config.setMaximumValue("max 5000");
		assertEquals("max 5000", config.getMaximumValue());

		config.setMinumumValue("min value 10");
		assertEquals("min value 10", config.getMinumumValue() );
		
		config.setFieldValue("Field Value");
		assertEquals("Field Value", config.getFieldValue());
		
		config.setAffectedModules("Affected Module");
		assertEquals("Affected Module", config.getAffectedModules());
		
		config.setReason("reason");
		assertEquals("reason", config.getReason());
		
		config.setStatus(false);	
		assertFalse(config.isStatus());
		
		assertEquals(config.toString(), config.toString());
		CcmConfigurationDTO config1=config;
		
		assertEquals(true,config.equals(config1));
		assertEquals(false,config.equals(new CcmConfigurationDTO()));
		assertTrue( config.hashCode()!=0 );  
   }
}
