package com.example.scheduleservice.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scheduleservice.mail.MailScheduleService;

@RestController
@RequestMapping("/test")
public class TestResource {
	@Autowired
	MailScheduleService mailScheduleService;
	
	private static final Logger logger = LoggerFactory.getLogger(TestResource.class);
	
	@RequestMapping("/send-mail")
	public String getMailCron() {
		try {
			mailScheduleService.sendMailSchedule();
			return "oke";
		} catch (Exception e) {
			throw e;
		}
	}
}
