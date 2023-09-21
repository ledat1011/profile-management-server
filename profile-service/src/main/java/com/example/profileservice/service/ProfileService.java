package com.example.profileservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dataservice.entity.CreditProfileEntity;
import com.example.dataservice.repository.CreditProfileRepository;

@Service
public class ProfileService {
	@Autowired
	CreditProfileRepository creditProfileRepository;

	public List<CreditProfileEntity> getAll() {
		return creditProfileRepository.findAll();
	}
	
	public CreditProfileEntity getById(Integer id) {
		return creditProfileRepository.findById(id).orElse(null);
	}
}
