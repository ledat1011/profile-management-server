package com.example.profileservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dataservice.entity.CreditProfileEntity;
import com.example.dataservice.repository.CreditProfileRepository;
import com.example.profileservice.dto.CreditProfileDTO;

@Service
public class ProfileService {

	private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);
	@Autowired
	CreditProfileRepository creditProfileRepository;

	public List<CreditProfileEntity> getAll() {
		return creditProfileRepository.findAll();
	}

	public CreditProfileEntity getById(Integer id) {
		return creditProfileRepository.findById(id).orElse(null);
	}

	public Boolean deleteById(Integer id) {
		try {
			if (creditProfileRepository.existsById(id)) {
				creditProfileRepository.deleteById(id);
				logger.info("Deleting credit profile with ID: {}", id);
				return true;
			} else {
				logger.warn("credit profile with ID: {} not found", id);
			}
		} catch (Exception e) {

		}
		return false;
	}

	public CreditProfileEntity createProfile(CreditProfileDTO dto) {
		CreditProfileEntity entity = new CreditProfileEntity();
		entity.setFullName(dto.getFullName());
		entity.setDateOfBirth(dto.getDateOfBirth());
		entity.setIdentityNumber(dto.getIdentityNumber());
		entity.setPermanentAddress(dto.getPermanentAddress());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setEmail(dto.getEmail());
		entity.setMonthlyIncome(dto.getMonthlyIncome());
		entity.setIncomeSource(dto.getIncomeSource());
		entity.setTotalAssets(dto.getTotalAssets());
		entity.setTotalLiabilities(dto.getTotalLiabilities());
		entity.setCurrentCreditCardsOrLoans(dto.getCurrentCreditCardsOrLoans());
		entity.setCompanyName(dto.getCompanyName());
		entity.setOccupation(dto.getOccupation());
		entity.setJobPosition(dto.getJobPosition());
		entity.setJobDurationInMonths(dto.getJobDurationInMonths());
		entity.setGuarantorName(dto.getGuarantorName());
		entity.setGuarantorRelationship(dto.getGuarantorRelationship());
		entity.setGuarantorPhone(dto.getGuarantorPhone());
		entity.setGuarantorEmail(dto.getGuarantorEmail());

		return creditProfileRepository.save(entity);
	}
}
