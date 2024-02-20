package com.vasy.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vasy.security.dto.UserDetailDto;
import com.vasy.security.model.Authorities;
import com.vasy.security.model.Users;
import com.vasy.security.repository.AuthoritiesRepository;
import com.vasy.security.repository.UsersRepository;

@Service
public class UserAndAuthoritiesServiceImpl implements UserAndAuthoritiesService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private AuthoritiesRepository authoritiesRepository;

	@Override
	public void addUserDetail(UserDetailDto userDetailDto) throws Exception {
		// TODO Auto-generated method stub

		Users user = new Users();
		user.setUsername(userDetailDto.getUsername());
		String encryptedPass = passwordEncoder.encode(userDetailDto.getPassword());
		user.setPassword(encryptedPass);
		user.setEnabled(true);
		 long roleId = Long.parseLong( userDetailDto.getAuthority());
		
		Authorities authorities=this.authoritiesRepository.findById(roleId).orElseThrow(() -> new Exception("No found"));
		user.setAuthorities(authorities);
		usersRepository.save(user);

		
	}

}
