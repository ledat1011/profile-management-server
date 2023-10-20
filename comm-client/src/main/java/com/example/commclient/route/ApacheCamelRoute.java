package com.example.commclient.route;

import java.lang.reflect.ParameterizedType;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.commclient.proccessor.TransformProcessorCustom;
import com.example.dataservice.entity.CreditProfileEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ApacheCamelRoute extends RouteBuilder {
	
	public static final String GET_BY_ID_ROUTE_ID = "getById";

	@Autowired 
	TransformProcessorCustom processor;
	
	@Autowired
	ResponseCreditDetailProcessor responseProcessor;
	
    @Override
    public void configure() throws Exception {
        from("direct:startGetAllByApache")
        .routeId(GET_BY_ID_ROUTE_ID)
        .choice()
        	.when(header("Content-Type").isEqualToIgnoreCase("application/xml")) //if content type of incoming request is xml
        	.setProperty("contentType", constant("xml"))
        	.end()
        .process(processor)
        .end()
        ;
    }
}


@Component
class ResponseCreditDetailProcessor extends ConvertTypeProcessor<CreditProfileEntity> {
	
	
}

class ConvertTypeProcessor<T> implements Processor {
	
	@Autowired
	private ObjectMapper mapper;
	  private Class<T> type;

	  @SuppressWarnings("unchecked")
	public ConvertTypeProcessor() {
	    this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
	  }
	
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
		exchange.getIn().setBody(mapper.readValue(exchange.getMessage().getBody(String.class), type));
	}
	
}
