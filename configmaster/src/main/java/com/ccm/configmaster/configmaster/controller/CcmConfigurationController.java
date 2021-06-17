package com.ccm.configmaster.configmaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccm.configmaster.configmaster.dto.CcmConfigurationDTO;
import com.ccm.configmaster.configmaster.service.CcmConfigurationService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Abhishek
 *
 */

@Slf4j
@RestController
@RequestMapping("/api")
public class CcmConfigurationController {

	@Autowired
	private CcmConfigurationService configurationService;

	/**
	 * @param id
	 * @return CcmConfigurationDTO
	 */
	@Operation(summary = "Give back the Configuration recode of the given ID", description = "It will return the configuration record for the given Id if the id not exist it will throw the exception", tags = {
			"" + "GET" })
	@Cacheable(value = "configurations", key="#id")
	@GetMapping("/getid/{id}")
	public CcmConfigurationDTO getConfigurationById(@PathVariable int id) {
		log.info("Get by Field Id Url Hit: /getid/id ");
		return configurationService.getConfigurationById(id);
	}

	/**
	 * @param fieldCode
	 * @return CcmConfigurationDTO
	 */
	@Operation(summary = "Give back the Configuration recode of the given FieldCode", description = "It will return the configuration record for the given FieldCode if the FieldCode not exist it will throw the exception", tags = {
			"GET" })
	@Cacheable(value = "configurations", key="#fieldCode")
	@GetMapping("/get/{fieldCode}")
	public CcmConfigurationDTO getConfigurationByFieldCode(@PathVariable String fieldCode) {
		log.info("Get by Field Name Url Hit: /getid/fieldCode ");
		return configurationService.getConfigurationByFieldCode(fieldCode);
	}

	/**
	 * Get All Configuration present
	 * @return CcmConfigurationDTO
	 */
	@Operation(summary = "Give back the All the Configurations present in the database", description = "It will return the all configuration records", tags = {
			"GET All" })
	@GetMapping("/get")
	public List<CcmConfigurationDTO> getConfigurations() {
		log.info("Get All Records url: /get");
		return configurationService.getAllConfigurations();
	}

	/**
	 * Update Configuration
	 * @param configuration
	 * @return
	 */
	@Operation(summary = "To add the new configuration information", description = "If the id will be same than it will update the data otherwise it add the new configuration in the record", tags = {
			"POST" })
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public CcmConfigurationDTO addConfiguration(@RequestBody CcmConfigurationDTO configuration) {
		log.info("Post request to add the the record is hit URL: /add");
		return configurationService.addConfiguration(configuration);
	}

}
