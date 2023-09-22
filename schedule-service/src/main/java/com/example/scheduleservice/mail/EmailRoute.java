package com.example.scheduleservice.mail;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailRoute extends RouteBuilder {

	@Value("${spring.mail.properties.mail.smtp.auth}")
	private boolean auth;
	@Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	private boolean starttls;

	@Override
	public void configure() throws Exception {
	    from("seda:sendEmail")
	        .log(LoggingLevel.INFO, "SENDING EMAIL NOTIFICATION")
	        .to("smtps://{{spring.mail.host}}:{{spring.mail.ssl.port}}?username={{spring.mail.username}}&password={{spring.mail.password}}&mail.smtp.auth=true&mail.smtp.starttls.enable=true")
	        .log(LoggingLevel.INFO, "EMAIL NOTIFICATION SENT TO ${header.To}")
	        .stop();
	}


}
