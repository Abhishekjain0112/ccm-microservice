package com.ccm.configmaster.configmaster.exceptionhandler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.hibernate.PropertyValueException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ccm.configmaster.configmaster.dto.ErrorResponse;

@RestControllerAdvice
public class CcmConfigurationErrorHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ MethodArgumentNotValidException.class, PropertyValueException.class,
			DataIntegrityViolationException.class })
	public ErrorResponse handleExceptionValidation(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(),
				"Please check the Validation :" + ex.getMessage(), request.getRequestURI());
	}

	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler({ ConstraintViolationException.class,
			org.hibernate.exception.ConstraintViolationException.class })
	public ErrorResponse handleExceptionConstraintValidation(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(new Date(), HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.getReasonPhrase(),
				"Duplicate Entry for Unique Key:" + ex.getMessage(), request.getRequestURI());
	}

	@ExceptionHandler({ Exception.class })
	public ErrorResponse handleExceptionGlobal(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(new Date(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				"Global Exception Handler: " + ex.getMessage(), request.getRequestURI());
	}

}
