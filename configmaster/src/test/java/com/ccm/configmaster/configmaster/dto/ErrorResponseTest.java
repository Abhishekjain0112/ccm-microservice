package com.ccm.configmaster.configmaster.dto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;


@SpringBootTest
class ErrorResponseTest {

	@Mock
	HttpServletRequest request;

	   @Test
	   void testGeterAndSetter() {
		   
	       ErrorResponse eResponce= new ErrorResponse();
	   	Exception ex = new RuntimeException("Global Exception Handler Test");	 
		when(request.getRequestURI()).thenReturn("url");
	       
	       eResponce.setTimestamp(new Date());
	       assertEquals(eResponce.getTimestamp(), eResponce.getTimestamp());
	       
	       eResponce.setMessage("Please check the Validation :"+ex.getMessage());
	       assertEquals("Please check the Validation :"+ex.getMessage(), eResponce.getMessage());
	      
	       eResponce.setStatus(HttpStatus.NOT_FOUND.value());
	       assertEquals(eResponce.getStatus(),eResponce.getStatus());
	       
	       eResponce.setError( HttpStatus.NOT_FOUND.getReasonPhrase());
	       assertEquals(eResponce.getError(), eResponce.getError());
	       
	       eResponce.setPath(request.getRequestURI());
	       assertEquals(eResponce.getPath(), eResponce.getPath());
	       
	       assertEquals(eResponce.toString(), eResponce.toString());
	        
	       ErrorResponse eeResponce= new ErrorResponse(new Date(), HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.getReasonPhrase(), "Duplicate Entry for Unique Key:"+ex.getMessage(), request.getRequestURI());
	       ErrorResponse neweeResponce =eeResponce;
	       assertEquals(eeResponce, neweeResponce);
	        
		   
	   }
	
	
}
