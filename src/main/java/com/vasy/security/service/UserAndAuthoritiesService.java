package com.vasy.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vasy.security.dto.UserDetailDto;

public interface UserAndAuthoritiesService extends UserDetailsService{
	
	void addUserDetail(UserDetailDto userDetailDto) throws Exception;
}
