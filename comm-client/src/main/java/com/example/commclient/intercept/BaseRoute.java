package com.example.commclient.intercept;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spi.Synchronization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseRoute extends RouteBuilder {

	private static final Logger logger = LoggerFactory.getLogger(BaseRoute.class);
	
	public BaseRoute () {
//		this.configuration();
	}
	
	@Override
	public void configuration() {
		String URI = "http://*";
		interceptSendToEndpoint(URI).process(exchange -> {
			logger.info("Hi from before request intercept");
			String url = exchange.getIn().getHeader(Exchange.INTERCEPTED_ENDPOINT, String.class);
			String res = exchange.getMessage().getBody(String.class);
			String requestId = UUID.randomUUID().toString();
	        exchange.setProperty("RequestID", requestId);
			
			logger.info("URL Request: {}", url);
			
			exchange.getUnitOfWork();
		});
	}
}
