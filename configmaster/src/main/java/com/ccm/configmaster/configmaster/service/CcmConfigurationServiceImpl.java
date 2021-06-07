package com.ccm.configmaster.configmaster.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccm.configmaster.configmaster.dto.CcmConfigurationDTO;
import com.ccm.configmaster.configmaster.exception.DataNotFoundException;
import com.ccm.configmaster.configmaster.model.CcmConfiguration;
import com.ccm.configmaster.configmaster.repository.CcmConfigurationrRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CcmConfigurationServiceImpl implements CcmConfigurationService {

	@Autowired
	private CcmConfigurationrRepo configurationRepo;

	@Override
	public List<CcmConfigurationDTO> getAllConfigurations() {
		log.info("Get All Configuration Method Started");
		List<CcmConfiguration> configList = configurationRepo.findAll();
		List<CcmConfigurationDTO> configDTOList = new ArrayList<>();
		for (CcmConfiguration c : configList) {
			configDTOList.add(getDtoFromConfig(c));
		}
		log.info("Get All Configuration Execution Compelte");
		return configDTOList;
	}

	@Override
	@Transactional
	public CcmConfigurationDTO getConfigurationById(int id) {
		log.info("Get Configuration By Id Configuration Method Started");
		Optional<CcmConfiguration> data = configurationRepo.findById(id);
		if (data.isPresent()) {
			log.info("Get Configuration By Id Configuration Execution Compelte");
			return getDtoFromConfig(data.get());
		} else {
			log.info("Element with id is not present in the table");
			throw new DataNotFoundException("Data with id [" + id + "] Found");
		}

	}

	@Transactional
	@Override
	public CcmConfigurationDTO addConfiguration(CcmConfigurationDTO configurationDto) {
		log.info("AddConfiguration method starts execution");
		var config = getConfigFromDto(configurationDto);
		CcmConfiguration result = configurationRepo.save(config);
		log.info("AddConfiguration method ends execution");
		return getDtoFromConfig(result);
	}

	@Override
	public CcmConfigurationDTO getConfigurationByFieldCode(String fieldCode) {
		log.info("Get Configuration By fieldCode Configuration Method Started");
		CcmConfiguration result = configurationRepo.getByFieldCode(fieldCode);

		CcmConfigurationDTO dtoFromConfig = getDtoFromConfig(result);
		log.info("Get Configuration By fieldCode Configuration Method  Execution Compelte");
		return dtoFromConfig;

	}

	@Override
	public CcmConfiguration getConfigFromDto(CcmConfigurationDTO configurationDto) {
		log.info("Change DTO to Config model");
		var config = new CcmConfiguration();
		config.setCcmConfigId(configurationDto.getCcmConfigId());
		config.setFieldCode(configurationDto.getFieldCode());
		config.setFieldName(configurationDto.getFieldName());
		config.setFieldDescription(configurationDto.getFieldDescription());
		config.setRequired(configurationDto.isRequired());
		config.setDataFormat(configurationDto.getDataFormat());
		config.setFieldDefaultValue(configurationDto.getFieldDefaultValue());
		config.setMaximumValue(configurationDto.getMaximumValue());
		config.setMinumumValue(configurationDto.getMinumumValue());
		config.setFieldValue(configurationDto.getFieldValue());
		config.setAffectedModules(configurationDto.getAffectedModules());
		config.setReason(configurationDto.getReason());
		config.setCreatedOn(configurationDto.getCreatedOn());
		config.setUpdatedOn(configurationDto.getUpdatedOn());
		config.setStatus(configurationDto.isStatus());
		return config;
	}

	@Override
	public CcmConfigurationDTO getDtoFromConfig(CcmConfiguration configuration) {
		log.info("Changed Config Model to DTO");
		var configDto = new CcmConfigurationDTO();
		configDto.setCcmConfigId(configuration.getCcmConfigId());
		configDto.setFieldCode(configuration.getFieldCode());
		configDto.setFieldName(configuration.getFieldName());
		configDto.setFieldDescription(configuration.getFieldDescription());
		configDto.setRequired(configuration.isRequired());
		configDto.setDataFormat(configuration.getDataFormat());
		configDto.setFieldDefaultValue(configuration.getFieldDefaultValue());
		configDto.setMaximumValue(configuration.getMaximumValue());
		configDto.setMinumumValue(configuration.getMinumumValue());
		configDto.setFieldValue(configuration.getFieldValue());
		configDto.setAffectedModules(configuration.getAffectedModules());
		configDto.setReason(configuration.getReason());
		configDto.setCreatedOn(configuration.getCreatedOn());
		configDto.setUpdatedOn(configuration.getUpdatedOn());
		configDto.setStatus(configuration.isStatus());
		return configDto;
	}

}
