package com.ccm.configmaster.configmaster.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CcmConfigurationTest {

    CcmConfiguration createInstance() {
	   return new CcmConfiguration();
   }
   @Test
    void testGetccmConfigId() {
	   CcmConfiguration config=  createInstance();
	   int id = config.getCcmConfigId();
	  
   }

   @Test
    void testToString() {
	   CcmConfiguration config=  createInstance();
	   String s= createInstance().toString();
   }
   
   
   
   
}
