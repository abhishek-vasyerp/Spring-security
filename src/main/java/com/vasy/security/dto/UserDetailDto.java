package com.vasy.security.dto;

import lombok.Data;

@Data
public class UserDetailDto {
	
	private long id;	
	private String username;
	private String password;
	private String authority;

}
