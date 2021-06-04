package com.ccm.configmaster.configmaster.service;

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
	public List<CcmConfiguration> getAllConfigurations() {
		
		return configurationRepo.findAll();
	}

	@Override
	@Transactional
	public CcmConfiguration getConfigurationById(int id) {
		
		 Optional<CcmConfiguration> data = configurationRepo.findById(id);
		 
		
		 if(data.isPresent())
			 return data.get();
		 else {
			 throw new DataNotFoundException("Data Not Found");
		 }
		 
			 
		
	}

	@Transactional
	@Override
	public CcmConfiguration addConfiguration(CcmConfigurationDTO configurationDto) {
		
		var config = new CcmConfiguration();		
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
		
		 return configurationRepo.save(config);
	}

	@Override
	public CcmConfiguration getConfigurationByFieldCode(String fieldCode) {
		 return configurationRepo.getByFieldCode(fieldCode);
	
	}

}
