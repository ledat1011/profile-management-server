package com.example.profileservice.jwt.impl;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.example.profileservice.jwt.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtImpl implements JWT {

	@Override
	public String createToken() {
//        Claims claims = Jwts.claims().setSubject("Test");
//        claims.put("firstName",user.getFirstName());
//        claims.put("lastName",user.getLastName());
//        Date tokenCreateTime = new Date();
//        Date tokenValidity = new Date(tokenCreateTime.getTime() + TimeUnit.MINUTES.toMillis(accessTokenValidity));
//        return Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(tokenValidity)
//                .signWith(SignatureAlgorithm.HS256, secret_key)
//                .compact();
		return "";
	}

}
