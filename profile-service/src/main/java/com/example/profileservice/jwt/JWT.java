package com.example.profileservice.jwt;

import org.springframework.security.core.userdetails.User;

public interface JWT {
	String createToken(User user);
	
    public boolean validateToken(String token);
    
    String getUserNameFromJwt(String token);
}
