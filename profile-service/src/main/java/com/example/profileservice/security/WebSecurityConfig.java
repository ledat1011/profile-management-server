package com.example.profileservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable().authorizeRequests()
               .antMatchers("/").permitAll() // Có nghĩa là request "/" ko cần phải đc xác thực
               .antMatchers(HttpMethod.POST, "/login").permitAll() // Request dạng POST tới "/login" luôn được phép truy cập dù là đã authenticated hay chưa
               .anyRequest().authenticated() // Các request còn lại đều cần được authenticated
               .and().logout()
               .and()
               .addFilterBefore(null, null)
               ;
   }
   

   
   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }
}
