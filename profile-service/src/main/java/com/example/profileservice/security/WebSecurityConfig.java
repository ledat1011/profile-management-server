package com.example.profileservice.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.profileservice.jwt.impl.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	MyUserDetailService myUserDetailService;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
    @Autowired
    @Qualifier("delegatedAuthenticationEntryPoint")
    AuthenticationEntryPoint authEntryPoint;
	
    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }
	
	
   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable().authorizeRequests()
               .antMatchers("/").permitAll() // Có nghĩa là request "/" ko cần phải đc xác thực
               .antMatchers(HttpMethod.POST, "/api/v1/auth/login").permitAll() // Request dạng POST tới "/login" luôn được phép truy cập dù là đã authenticated hay chưa
               .anyRequest().authenticated() // Các request còn lại đều cần được authenticated
               .and().exceptionHandling()
               .authenticationEntryPoint(authEntryPoint)
               .and().logout()
               ;
       
       http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
   }
   

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder);
   }
   
   @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
   @Override
   public AuthenticationManager authenticationManagerBean() throws Exception {
       // Get AuthenticationManager bean
       return super.authenticationManagerBean();
   }
   
}
