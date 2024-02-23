package com.vasy.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasy.security.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	
	Optional<Users> findByUsername(String username);
	
}
