package com.example.commclient.intercept;

import java.io.IOException;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.FeignException;
import feign.InvocationContext;
import feign.Response;
import feign.ResponseInterceptor;
import feign.codec.DecodeException;
import feign.codec.Decoder;

@Component
public class FeignResponseInterceptor implements Decoder {
	private static final Logger logger = LoggerFactory.getLogger(FeignResponseInterceptor.class);

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
		// TODO Auto-generated method stub
		return objectMapper.readValue(response.body().asInputStream(), objectMapper.constructType(type));
	}

}