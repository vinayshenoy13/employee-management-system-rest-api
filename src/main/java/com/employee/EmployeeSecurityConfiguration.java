package com.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// To enable apis that perform modification like post,put, delete
		http.csrf(csrf_token -> csrf_token.disable());

		// This line of code is used to make all apis public
		/*
		 * http.authorizeHttpRequests(http_request-> http_request
		 * .anyRequest()
		 * .permitAll())
		 * .httpBasic(Customizer.withDefaults());
		 */

		// making all api secure
		/*
		 * http.authorizeHttpRequests(http_request-> http_request
		 * .anyRequest()
		 * .authenticated())
		 * .httpBasic(Customizer.withDefaults());
		 */

		return http.build();
	}
}
