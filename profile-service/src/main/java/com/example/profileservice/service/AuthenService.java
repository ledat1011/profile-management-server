package com.example.profileservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.profileservice.common.BaseService;
import com.example.profileservice.dto.LoginRequest;
import com.example.profileservice.dto.LoginResponse;
import com.example.profileservice.jwt.impl.JwtImpl;

@Service
public class AuthenService extends BaseService {
	
	@Autowired 
	AuthenticationManager authenticationManager;
	
    @Autowired
    private JwtImpl tokenProvider;
	
	public LoginResponse login(LoginRequest loginRequest) {
		
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        
        // cập nhật phiên làm việc
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = tokenProvider.createToken((User)authentication.getPrincipal());
        return new LoginResponse(jwt);
	}
}
