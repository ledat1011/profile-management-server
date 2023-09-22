package com.example.profileservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dataservice.repository.SystemParamRepository;

@RestController
@RequestMapping("/test")
public class TestResource {
	@Autowired
	SystemParamRepository systemParamRepository;
	
	@RequestMapping("/mail-schedule")
	public String getMailCron() {
		return systemParamRepository
				.findByParamKeyAndParamGroup("server","Schedule_Mail")
				.getParamValue();
	}
}
