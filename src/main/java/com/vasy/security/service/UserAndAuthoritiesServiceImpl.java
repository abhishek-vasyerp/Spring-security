package com.vasy.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vasy.security.dto.UserDetailDto;
import com.vasy.security.exception.RoleNotFoundException;
import com.vasy.security.model.Authorities;
import com.vasy.security.model.Users;
import com.vasy.security.repository.AuthoritiesRepository;
import com.vasy.security.repository.UsersRepository;

@Service
public class UserAndAuthoritiesServiceImpl implements UserAndAuthoritiesService,UserDetailsService {
	
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
		
		Authorities authorities=this.authoritiesRepository.findById(roleId).orElseThrow(() -> new RoleNotFoundException("No found"));
		user.setAuthorities(authorities);
		usersRepository.save(user);

	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		try {
			return this.usersRepository.findByUsername(username).orElseThrow(() -> new Exception("No id"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
