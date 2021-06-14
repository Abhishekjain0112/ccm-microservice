package com.ccm.configmaster.configmaster.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	
	  @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
									.withUser("abhi")
									.password("abhi")
									.roles("ADMIN");
	}
	
	  
	  @Override 
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
					.authorizeRequests()	
					.antMatchers("/**").hasRole("ADMIN")
					.and()
					.httpBasic();
	}
	  
	  
	  @Bean
	  public PasswordEncoder passwordEncoder() {
		  return NoOpPasswordEncoder.getInstance();
	  }
	  
	 
	    @Bean
	    CorsConfigurationSource corsConfigurationSource() {
	        var configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("*"));
	        configuration.setAllowedMethods(Arrays.asList("*"));
	        configuration.setAllowedHeaders(Arrays.asList("*"));
	        configuration.setAllowCredentials(true);
	        var source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }

 
	  
	  
	  
	  
	  
	  
}