package com.example.profileservice.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dataservice.entity.RoleEntity;
import com.example.dataservice.entity.UserEntity;
import com.example.dataservice.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserEntity user = userRepository.findByusername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		Set<RoleEntity> permission = user.getRoles();
		String[] roles = permission.stream().map(v -> v.getName()).toArray(String[]::new);

		// Create a UserDetails instance from the UserEntity.
		return User.withUsername(user.getUsername()).password(user.getPassword())
				// You might want to add roles here depending on your application
				.passwordEncoder(password -> passwordEncoder.encode(password))
				.roles(roles).build();
	}

}
