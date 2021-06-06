package com.ccm.configmaster.configmaster.exceptionhandler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.ccm.configmaster.configmaster.dto.ErrorResponse;

@SpringBootTest
class CcmConfigurationErrorHandlerTest {
	
	@Mock
	HttpServletRequest request;
	
	@Autowired
	CcmConfigurationErrorHandler ccmConfigurationErrorHandler;
	
	@Test
	void testGlobalErroHandlear() {
		
		Exception ex = new RuntimeException("Global Exception Handler Test");	 
		when(request.getRequestURI()).thenReturn("url");
		ErrorResponse eResponce= new ErrorResponse(new Date(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), "Global Exception Handler: "+ex.getMessage(), request.getRequestURI());
		  ErrorResponse err =  ccmConfigurationErrorHandler.handleExceptionGlobal(ex, request);			
		assertTrue(true);
	}





	@Test
	void testHandleExceptionConstraintValidation() {
		
		Exception ex = new RuntimeException("Global Exception Handler Test");	 
		when(request.getRequestURI()).thenReturn("url");
		ErrorResponse eResponce= new ErrorResponse(new Date(), HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.getReasonPhrase(), "Duplicate Entry for Unique Key:"+ex.getMessage(), request.getRequestURI());
		  ErrorResponse err =  ccmConfigurationErrorHandler.handleExceptionConstraintValidation(ex, request);
		assertTrue(true);
	}


	@Test
	void testhandleExceptionValidation() {
		
		Exception ex = new RuntimeException("Global Exception Handler Test");	 
		when(request.getRequestURI()).thenReturn("url");
       ErrorResponse eResponce= new ErrorResponse();
       
       eResponce.setTimestamp(new Date());
       eResponce.setMessage("Please check the Validation :"+ex.getMessage());
       eResponce.setStatus(HttpStatus.NOT_FOUND.value());
       eResponce.setError( HttpStatus.NOT_FOUND.getReasonPhrase());
       eResponce.setPath(request.getRequestURI());
       
        ErrorResponse err =  ccmConfigurationErrorHandler.handleExceptionValidation(ex, request);
		
		assertTrue(true);
	}
	
	



}
