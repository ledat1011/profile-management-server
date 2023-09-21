package com.example.profileservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dataservice.entity.CreditProfileEntity;
import com.example.profileservice.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileResource {
	@Autowired
	ProfileService profileService;

	@RequestMapping("/get-all")
	public List<CreditProfileEntity> getAll() {
		return profileService.getAll();
	}

	@RequestMapping("/get")
	public CreditProfileEntity getById(@RequestParam(name = "id") Integer id) {
		return profileService.getById(id);
	}
}
