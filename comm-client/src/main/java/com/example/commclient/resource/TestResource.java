package com.example.commclient.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.commclient.service.TestService;

@Component
public class TestResource {
	
	@Autowired
	TestService testService;
	
	public String test() {
		return randomString();
	}
	
	private String randomString() {
		return "A";
	}
}
