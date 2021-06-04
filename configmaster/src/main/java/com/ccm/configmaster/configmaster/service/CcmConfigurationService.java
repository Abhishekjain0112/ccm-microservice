package com.ccm.configmaster.configmaster.service;

import java.util.List;

import com.ccm.configmaster.configmaster.dto.CcmConfigurationDTO;
import com.ccm.configmaster.configmaster.model.CcmConfiguration;

public interface CcmConfigurationService {

	public List<CcmConfiguration> getAllConfigurations();

	public CcmConfiguration getConfigurationById(int id);

	public CcmConfiguration addConfiguration(CcmConfigurationDTO configurationDto);
	
	public CcmConfiguration getConfigurationByFieldCode(String fieldCode);
	
}
