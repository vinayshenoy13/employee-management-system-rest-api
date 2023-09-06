package com.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// To enable apis that perform modification like post,put, delete
		http.csrf(csrf_token -> csrf_token.disable());

//		making GET all api public and all other apis secure
		http.authorizeHttpRequests(http_request -> http_request
				.requestMatchers(HttpMethod.GET,"/").permitAll()
				.requestMatchers(HttpMethod.GET,"/employees").hasRole("HR")
				.requestMatchers(HttpMethod.POST,"/employees").permitAll()
//				.requestMatchers(HttpMethod.GET,"/accounts/{id}(id=employee.getId)").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET,"/accounts/**").hasRole("EMPLOYEE")
				);
				
		return http.build();
	}
	
	@Bean
	public UserDetailsService user() {
		UserDetails user1 = User.builder().username("vinay").password("vinay123").roles("HR").build();
		
		return new InMemoryUserDetailsManager(user1);
	}
}
