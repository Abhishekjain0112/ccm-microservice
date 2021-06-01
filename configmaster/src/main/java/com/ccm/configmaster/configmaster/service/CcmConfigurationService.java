package com.ccm.configmaster.configmaster.service;

import java.util.List;

import com.ccm.configmaster.configmaster.model.CcmConfiguration;

public interface CcmConfigurationService {

	public List<CcmConfiguration> getAllConfigurations();

	public CcmConfiguration getConfigurationById();

	public CcmConfiguration addConfiguration(CcmConfiguration configuration);
}
