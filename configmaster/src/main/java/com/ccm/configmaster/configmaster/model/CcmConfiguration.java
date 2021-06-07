package com.ccm.configmaster.configmaster.model;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ccm_config_master")
public class CcmConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ccm_config_id")
	private int ccmConfigId;

	@NotBlank
	@Column(name = "field_code", length = 10, nullable = false, unique = true)
	private String fieldCode ;

	@Column(name = "field_name", length = 20, nullable = false)
	private String fieldName ;

	@Column(name = "field_description", length = 200, nullable = false)
	private String fieldDescription ;

	@Column(name = "required", nullable = false)
	private boolean required ;

	@Column(name = "data_format", length = 50, nullable = true)
	private String dataFormat = "";

	@Column(name = "field_default_value", length = 50, nullable = true)
	private String fieldDefaultValue = "";

	@Column(name = "maximum_value", length = 50, nullable = true)
	private String maximumValue = "";

	@Column(name = "minumum_value", length = 50, nullable = true)
	private String minumumValue = "";

	@Column(name = "field_value", length = 200, nullable = true)
	private String fieldValue = "";

	@Column(name = "affected_modules", length = 200, nullable = true)
	private String affectedModules = "";

	@Column(name = "reason", length = 20, nullable = true)
	private String reason = "";

	@Column(name = "created_on", nullable = false)
	private Timestamp createdOn = Timestamp.from(Instant.now());

	@Column(name = "updated_on", nullable = false)
	private Timestamp updatedOn = Timestamp.from(Instant.now());

	@Column(name = "status", nullable = false)
	private boolean status = false;

}
