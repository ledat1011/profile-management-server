package com.example.scheduleservice.mail;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

public class GmailImpl implements MailService{

    @Autowired
    private ProducerTemplate producerTemplate;

    @Value("${spring.mail.username}")
    private String from;
	
	@Override
	public void sendEmail(String recipient, String subject, String body) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("To", recipient);
        headers.put("From", from);
        headers.put("Subject", subject);
        producerTemplate.sendBodyAndHeaders("seda:sendEmail", body, headers);
    }

}
