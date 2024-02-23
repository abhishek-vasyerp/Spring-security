package com.vasy.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasy.security.model.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Long >{

}
