package com.example.profileservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginRequest {
	
	/** The username. */
	@JsonProperty("username")
    private String username;
	
	/** The password. */
	@JsonProperty("password")
    private String password;
}
