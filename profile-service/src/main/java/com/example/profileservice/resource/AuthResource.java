package com.example.profileservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.profileservice.dto.LoginRequest;
import com.example.profileservice.dto.LoginResponse;
import com.example.profileservice.service.AuthenService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthResource {
	
	@Autowired
	AuthenService service;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody  LoginRequest loginRequest) {
		return ResponseEntity.ok(service.login(loginRequest));
	}
}
