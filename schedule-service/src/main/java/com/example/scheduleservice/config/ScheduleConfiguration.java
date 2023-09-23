package com.example.scheduleservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.dataservice.repository.SystemParamRepository;
import com.example.scheduleservice.mail.GmailImpl;
import com.example.scheduleservice.mail.MailService;
import com.example.scheduleservice.utils.StringUtils;

@Configuration
public class ScheduleConfiguration {

	@Autowired
	SystemParamRepository systemParamRepository;

	@Value("${spring.mail.type}")
	private String mailType;

	@Bean
	public String getMailScheduleCron() {
		return systemParamRepository
				.findByParamKeyAndParamGroup(StringUtils.PARAM_KEY_SCHEDULE, StringUtils.PARAM_GROUP_SERVER)
				.getParamValue();
	}

	@Bean
	public MailService mailFactory() {
		switch (mailType) {
		case "Gmail":
			return new GmailImpl();
		default:
			return new GmailImpl();
		}
	}
}
