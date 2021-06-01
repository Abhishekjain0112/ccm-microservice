package com.ccm.configmaster.configmaster.model;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ccm_config_master")
public class CcmConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ccm_config_id" )
	private int ccmConfigId;
	
	@Column(name = "field_code",length =10,nullable = false)
	private String fieldCode;

	@Column(name = "field_name",length =20,nullable = false)
	private String fieldName;
	
	@Column(name = "field_description",length =200, nullable = false)
	private String fieldDescription;
	
	@Column(name = "required")
	private boolean required;

	@Column(name = "data_format",length =50,nullable = true)
	private String dataFormat;
	
	
	@Column(name = "field_default_value",length =50,nullable = true)
	private String fieldDefaultValue;

	@Column(name = "maximum_value",length =50,nullable = true)
	private String maximumValue;
	
	@Column(name = "minumum_value",length =50, nullable = true)
	private String minumumValue;
	
	@Column(name = "field_value",length =200, nullable = true)
	private String field_value;
	
	@Column(name = "affected_modules",length =200, nullable = true)
	private String affected_modules ;
	
	@Column(name = "reason",length =20, nullable = true)
	private String reason;
		
	@Column(name = "created_on", nullable = false)
	private Timestamp createdOn;

	@Column(name = "updated_on", nullable = false)
	private Timestamp updatedOn;
	
	@Column(name = "status", nullable = false)
	private boolean status;	

	
}