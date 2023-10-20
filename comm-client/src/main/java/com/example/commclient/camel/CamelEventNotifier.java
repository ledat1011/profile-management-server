package com.example.commclient.camel;

import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.impl.event.ExchangeSendingEvent;
import org.apache.camel.spi.CamelEvent;
import org.apache.camel.spi.CamelEvent.ExchangeSentEvent;
import org.apache.camel.support.EventNotifierSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
public class CamelEventNotifier extends EventNotifierSupport {
	private static final Logger logger = LoggerFactory.getLogger(CamelEventNotifier.class);

	@Override
	public void notify(CamelEvent event) throws Exception {
		//handle sending event
		if (event instanceof ExchangeSendingEvent) {
			ExchangeSendingEvent sendingEvent = (ExchangeSendingEvent) event;
			Exchange exchange = sendingEvent.getExchange();
			String url = sendingEvent.getEndpoint().getEndpointUri();
			String requestId = UUID.randomUUID().toString();
			exchange.setProperty("RequestID", requestId);
			logger.info("URL Request: {}", url);
		}
		
		//handle sent event
		if (event instanceof ExchangeSentEvent) {
			ExchangeSentEvent sentEvent = (ExchangeSentEvent) event;
			Exchange exchange = sentEvent.getExchange();
			String response = exchange.getMessage().getBody(String.class);
			String requestId = exchange.getProperty("RequestID", String.class);
			logger.info("Endpoint: " + sentEvent.getEndpoint() + " Response: " + response);
		}
	}

}
