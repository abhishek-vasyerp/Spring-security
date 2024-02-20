package com.vasy.security.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		
				.authorizeHttpRequests(
						authorizeRequests -> authorizeRequests
								.requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
								.requestMatchers("/user/**").hasAnyAuthority("USER","ADMIN")
								.requestMatchers("/public/**").permitAll()
								.anyRequest().permitAll())
								
				.formLogin(	
					// Customizer.withDefaults()
					
					formLogin -> formLogin
					 //.loginPage("/customLogin")        
					// .loginProcessingUrl("/authenticateTheUser") 
					// .permitAll()
					.successHandler(new MyUniqueAuthenticationHandler()))   		
				

				.logout(logout -> logout.permitAll());
                //.permitAll())
			
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
