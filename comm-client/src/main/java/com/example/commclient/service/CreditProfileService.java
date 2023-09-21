package com.example.commclient.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dataservice.entity.CreditProfileEntity;

@FeignClient(name = "profile-service")
public interface CreditProfileService {
	@GetMapping("/profile/get-all")
	public List<CreditProfileEntity> getAll();
	
	@GetMapping("/profile/get")
	public CreditProfileEntity getById(@RequestParam(name = "id") Integer id);
}
