package com.ccm.configmaster.configmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccm.configmaster.configmaster.model.CcmConfiguration;

public interface CcmConfigMasterRepo extends JpaRepository<CcmConfiguration, Integer> {

}
