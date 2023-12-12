package com.example.profileservice.jwt.impl;

import java.util.Date;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.dataservice.UserDto;
import com.example.profileservice.jwt.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtImpl implements JWT {

	private String secretKey = "your-secret-key";
	private long validityInMilliseconds = 3600000;

	@Override
	public String createToken(User user) {
		Date now = new java.util.Date();
		Date validity = new Date(now.getTime() + validityInMilliseconds);
		return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(now)
				.setExpiration(validity)
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();
	}

	@Override
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}

	@Override
	public String getUserNameFromJwt(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}
	
	

}
