//package com.vasy.security.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.vasy.security.model.Users;
//import com.vasy.security.repository.UsersRepository;
//
//@Service
//public class UserDetailService implements UserDetailsService {
//
//	@Autowired
//	private UsersRepository usersRepository;
//	
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////		try {
//		Users user=	this.usersRepository.findByUsername(username).orElseThrow(() -> new Exception("No id"));
//		return user;
////		} catch (Exception e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		return null;
////	}
//
//}
//}