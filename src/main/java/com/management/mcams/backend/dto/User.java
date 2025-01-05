package com.management.mcams.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class User {

	@JsonProperty("userId")
	private Long userId;
	
	@JsonProperty("username")
	private String userName;
	
	@JsonProperty("password")
	private String userPassword;
	
}
