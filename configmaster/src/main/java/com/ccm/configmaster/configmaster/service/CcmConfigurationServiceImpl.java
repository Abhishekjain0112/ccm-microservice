package com.ccm.configmaster.configmaster.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccm.configmaster.configmaster.model.CcmConfiguration;
import com.ccm.configmaster.configmaster.repository.CcmConfigurationrRepo;

@Service
public class CcmConfigurationServiceImpl implements CcmConfigurationService{

	@Autowired
	private CcmConfigurationrRepo configurationRepo;
	
	@Override
	public List<CcmConfiguration> getAllConfigurations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CcmConfiguration getConfigurationById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public CcmConfiguration addConfiguration(CcmConfiguration configuration) {
		
		 return configurationRepo.save(configuration);
	}

}
