package com.example.commclient.service;

import org.springframework.stereotype.Service;

import com.example.commclient.resource.TestResource2;
import com.google.inject.Inject;

@Service
public class TestService {
	
	@Inject TestResource2 testResource2;
	
	public TestResource2 testMethod() {
		return testResource2;
	}
}
