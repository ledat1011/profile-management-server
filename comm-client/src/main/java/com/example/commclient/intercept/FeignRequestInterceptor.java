package com.example.commclient.intercept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class FeignRequestInterceptor implements RequestInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(FeignRequestInterceptor.class);

	@Override
	public void apply(RequestTemplate template) {
		// TODO Auto-generated method stub
		logger.info(template.url());
	}

}
