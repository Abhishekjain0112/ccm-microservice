package com.ccm.configmaster.configmaster.dto;

import java.sql.Timestamp;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CcmConfigurationDTO {
	
	private int ccmConfigId;
	private String fieldCode;
	private String fieldName;
	private String fieldDescription;
	private boolean required;
	private String dataFormat;
	private String fieldDefaultValue;
	private String maximumValue;
	private String minumumValue;
	private String fieldValue;
	private String affectedModules ;
	private String reason;
	private Timestamp createdOn=Timestamp.from(Instant.now());
	private Timestamp updatedOn=Timestamp.from(Instant.now());
	private boolean status;	
	
}
