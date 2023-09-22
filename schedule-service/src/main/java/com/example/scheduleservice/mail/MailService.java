package com.example.scheduleservice.mail;

public interface MailService {
	void sendEmail(String recipient, String subject, String body);
}
