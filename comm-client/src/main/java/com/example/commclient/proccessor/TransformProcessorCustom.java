package com.example.commclient.proccessor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class TransformProcessorCustom implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.print("TEST NE");
		exchange.getIn().setBody("TESTNE");
		
	}
	
}