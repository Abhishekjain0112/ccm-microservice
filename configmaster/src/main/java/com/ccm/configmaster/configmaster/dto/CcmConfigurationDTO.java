package com.ccm.configmaster.configmaster.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CcmConfigurationDTO implements Serializable{
	
	private int ccmConfigId;
	@Schema(description = "Unique FieldCode.", example = "101Field", required = true)
	private String fieldCode;
	@Schema(description = "Field Name ", example = "FieldName", required = true)
	private String fieldName;
	private String fieldDescription;
	@NotEmpty
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
