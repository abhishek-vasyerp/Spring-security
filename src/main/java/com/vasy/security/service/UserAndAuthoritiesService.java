package com.vasy.security.service;

import com.vasy.security.dto.UserDetailDto;

public interface UserAndAuthoritiesService {
	
	void addUserDetail(UserDetailDto userDetailDto) throws Exception;
}
