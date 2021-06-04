package com.ccm.configmaster.configmaster.service;

import java.util.List;

import com.ccm.configmaster.configmaster.dto.CcmConfigurationDTO;
import com.ccm.configmaster.configmaster.model.CcmConfiguration;

public interface CcmConfigurationService {

	public List<CcmConfigurationDTO> getAllConfigurations();

	public CcmConfigurationDTO getConfigurationById(int id);

	public CcmConfigurationDTO addConfiguration(CcmConfigurationDTO configurationDto);
	
	public CcmConfigurationDTO getConfigurationByFieldCode(String fieldCode);

	public CcmConfiguration getConfigFromDto(CcmConfigurationDTO configurationDto) ;
	public CcmConfigurationDTO getDtoFromConfig(CcmConfiguration configuration);
}
