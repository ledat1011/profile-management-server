package com.example.profileservice.test;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Test {
	public static void main(String[] args) throws InterruptedException {
        // Thay thế bằng khóa bí mật thật của bạn
        String secretKey = "your-secret-key";

        int time = 5000;
     // Tạo JWT với thời gian hết hạn sau 1 phút
        Date expirationDate = new Date(System.currentTimeMillis() + time); // 60,000 milliseconds = 1 minute
        // Tạo JWT
        String jwt = Jwts.builder()
            .setSubject("1234567890")
            .claim("name", "John Doe")
            .claim("email", "johndoe@example.com")
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .setExpiration(expirationDate)
            .compact();

        System.out.println("JWT: " + jwt);

        Thread.sleep(time );
        // Kiểm tra tính toàn vẹn và giải mã JWT
        try {
            Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();

            System.out.println("Subject: " + claims.getSubject());
            System.out.println("Name: " + claims.get("name", String.class));
            System.out.println("Email: " + claims.get("email", String.class));
        } catch (Exception e) {
            System.err.println("Không thể xác thực JWT: " + e.getMessage());
        }
    }
}
