package com.example.profileservice.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dataservice.entity.CreditProfileEntity;
import com.example.dataservice.repository.CreditProfileRepository;
import com.example.profileservice.common.BaseService;
import com.example.profileservice.dto.CreditProfileDTO;
import com.example.profileservice.filter.FilterDto;

@Service
public class ProfileService extends BaseService{

	private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);
	@Autowired
	CreditProfileRepository creditProfileRepository;
	
	@Autowired
	FilterService filterService;
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<CreditProfileEntity> getAll() {
		return creditProfileRepository.findAll();
	}

	public CreditProfileEntity getById(Integer id) {
		return creditProfileRepository.findById(id).orElse(null);
	}

	@Transactional
	public Boolean deleteById(List<Integer> ids) {
		try {
			creditProfileRepository.deleteAllById(ids);
			logger.info("Deleting credit profile with ID(s): {}", ids);
			return true;
		} catch (Exception e) {
			logger.error("Error deleting credit profiles with ID(s): {}. Reason: {}", ids, e.getMessage());
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
	
	public List<CreditProfileEntity> creditSerch(FilterDto filterDto) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CreditProfileEntity> criteriaQuery = criteriaBuilder.createQuery(CreditProfileEntity.class);
		Root<CreditProfileEntity> root = criteriaQuery.from(CreditProfileEntity.class);
		 
		Predicate predicate = filterService.buildPredicate(criteriaBuilder, root, filterDto.getCriteriaFilter());
		
		Order order = filterService.buildOrder(criteriaBuilder, root, filterDto.getSortItem());
		
        criteriaQuery.where(predicate);
        criteriaQuery.orderBy(order);
        TypedQuery<CreditProfileEntity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
	}
}
