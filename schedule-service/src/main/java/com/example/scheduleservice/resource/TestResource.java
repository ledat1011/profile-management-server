package com.example.scheduleservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scheduleservice.mail.MailScheduleService;

@RestController
@RequestMapping("/test")
public class TestResource {
	@Autowired
	MailScheduleService mailScheduleService;
	
	@RequestMapping("/send-mail")
	public String getMailCron() {
		try {
			mailScheduleService.sendMailSchedule();
			return "oke";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
