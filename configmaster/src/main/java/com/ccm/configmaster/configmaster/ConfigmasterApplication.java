package com.ccm.configmaster.configmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(
		info = @Info(title = "CCM Master Configuration Application", version = "1.0.0")
		)
public class ConfigmasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigmasterApplication.class, args);
	}

}
