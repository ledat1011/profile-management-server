package com.example.commclient.intercept;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
public class Interceptor implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// Logging or modifying the request
		logRequest(req);

		chain.doFilter(request, response);

		// Logging or modifying the response
		logResponse(res);
	}

	private void logRequest(HttpServletRequest request) {
		logger.info(request.getRequestURI());
		logger.info("Request URL: {}", request.getRequestURL());
	}

	private void logResponse(HttpServletResponse response) {
		// your logic to log or modify the response
		logger.info("Response status: {}", response.getStatus());
	}

}
