package com.example.commclient.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.commclient.service.TestService;

@SpringBootTest
public class TestResourceTest {
	
	@MockBean
	TestService testService;
	
	@Mock
	TestResource2 testResource2;
	
	@Autowired
	TestResource resource;
	
	@Test
	void test() {
		when(testService.testMethod()).thenReturn(testResource2);
		when(testResource2.someString()).thenReturn("ABC");
		String result = resource.test();
		
		assertEquals("ABC", result);
	}
}
