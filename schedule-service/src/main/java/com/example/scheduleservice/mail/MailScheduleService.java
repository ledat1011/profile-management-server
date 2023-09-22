package com.example.scheduleservice.mail;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.scheduleservice.common.BaseService;

@Service
public class MailScheduleService extends BaseService{
	private static final Logger logger = LoggerFactory.getLogger(MailScheduleService.class);
	
	@Autowired
	MailService mailService;
	
	@Scheduled(cron="#{@getMailCron}")
	public void sendMailSchedule() {
		mailService.sendEmail("ledat10111999@gmail.com", "test subject", "test content");
	}
}
