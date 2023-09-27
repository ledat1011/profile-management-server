package com.example.profileservice;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.example.profileservice", "com.example.dataservice"})
public class ProfileServiceApplication {

	@Value("${eureka.client.service-url.default-zone}")
	private String eurekaUrl;
	
	public static void main(String[] args) {

		SpringApplication.run(ProfileServiceApplication.class, args);
	}
	
    @PostConstruct
    public void init() {
        System.out.println("=====================" + eurekaUrl);
    }

}
