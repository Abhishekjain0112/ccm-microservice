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

@Service
public class CcmConfigurationServiceImpl implements CcmConfigurationService{

	@Autowired
	private CcmConfigurationrRepo configurationRepo;
	
	
	
	@Override
	public List<CcmConfigurationDTO> getAllConfigurations() {
		
		List<CcmConfiguration> configList= configurationRepo.findAll();
		List<CcmConfigurationDTO> configDTOList= new ArrayList<>();		
		for(CcmConfiguration c : configList) {
			configDTOList.add(getDtoFromConfig(c));
		}
		return configDTOList;
	}

	@Override
	@Transactional
	public CcmConfigurationDTO getConfigurationById(int id) {
		
		 Optional<CcmConfiguration> data = configurationRepo.findById(id);	
		 if(data.isPresent())
			 return     getDtoFromConfig(data.get());
		 else {
			 throw new DataNotFoundException("Data with id ["+id+"] Found");
		 }
		 
			 
		
	}

	@Transactional
	@Override
	public CcmConfigurationDTO addConfiguration(CcmConfigurationDTO configurationDto) {
		
		var config =  getConfigFromDto(configurationDto) ;
		  CcmConfiguration result = configurationRepo.save(config);
		  
		  return getDtoFromConfig(result);
	}

	@Override
	public CcmConfigurationDTO getConfigurationByFieldCode(String fieldCode) {
		  CcmConfiguration result = configurationRepo.getByFieldCode(fieldCode);
		  return getDtoFromConfig(result);
	
	}
	@Override
	public CcmConfiguration getConfigFromDto(CcmConfigurationDTO configurationDto) {
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
