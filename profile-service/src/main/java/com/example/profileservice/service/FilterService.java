package com.example.profileservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.example.profileservice.common.BaseService;
import com.example.profileservice.filter.ConditionTypeTextFilterEnum;
import com.example.profileservice.filter.CriteriaFilter;
import com.example.profileservice.filter.FilterBooleanValue;
import com.example.profileservice.filter.FilterTextValue;
import com.example.profileservice.filter.SortItem;
import com.example.profileservice.filter.SortTypeEnum;

@Service
public class FilterService extends BaseService {
	
	public Order buildOrder(CriteriaBuilder criteriaBuilder, Root root, SortItem sortItem) {
		Order order = null;
		if(sortItem !=null) {
			if(sortItem.getSortType().equals(SortTypeEnum.ASC.getValue())) {
				order = criteriaBuilder.asc(root.get(sortItem.getFieldName()));
			}else {
				order =  criteriaBuilder.desc(root.get(sortItem.getFieldName()));
			}
		}
		return order;
	}

	public Predicate buildPredicate(CriteriaBuilder criteriaBuilder, Root root, Map<String, CriteriaFilter> filter) {
		Predicate combinePredicate = criteriaBuilder.conjunction();
		List<Predicate> predicates = new ArrayList<>();
		for (var entry : filter.entrySet()) {
			Predicate predicate = null;
		    String key = entry.getKey();
		    CriteriaFilter criteria = entry.getValue();
		    if(criteria.getFilterTextValue() !=null) {
		    	predicate = buildTextPredicate(criteria, criteriaBuilder, root);
		    }
		    
		    if(criteria.getFilterBooleanValue() !=null) {
		    	predicate = buildTextPredicate(criteria, criteriaBuilder, root);
		    }
		   if(predicate !=null) {
			   predicates.add(predicate);
		   }
		    
		}
		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}
	
	private Predicate buildTextPredicate(CriteriaFilter filter, CriteriaBuilder  criteriaBuilder,Root<?> root) {
		Predicate predicate = null;
		FilterTextValue textFilter = filter.getFilterTextValue();
		ConditionTypeTextFilterEnum type = ConditionTypeTextFilterEnum.fromValue(textFilter.getConditionType().getConditionType());
		if(type == ConditionTypeTextFilterEnum.CONTAIN) {
			predicate = criteriaBuilder.like(root.get(filter.getFieldName()), "%"+textFilter.getValue()+"%");
		}
		if(type == ConditionTypeTextFilterEnum.DOES_NOT_CONTAIN) {
			predicate = criteriaBuilder.notLike(root.get(filter.getFieldName()), "%"+textFilter.getValue()+"%");
		}
		
		if(type == ConditionTypeTextFilterEnum.START_WITH) {
			predicate = criteriaBuilder.like(root.get(filter.getFieldName()), "%"+textFilter.getValue());
		}
		
		if(type == ConditionTypeTextFilterEnum.END_WITH) {
			predicate = criteriaBuilder.like(root.get(filter.getFieldName()), textFilter.getValue()+"%");
		}
		
		if(type == ConditionTypeTextFilterEnum.EXCACTLY) {
			predicate = criteriaBuilder.equal(root.get(filter.getFieldName()), textFilter.getValue());
		}
		
		return predicate;
	}
	
	private Predicate buildBooleanPredicate(CriteriaFilter filter, CriteriaBuilder  criteriaBuilder,Root<?> root) {
		Predicate predicate = null;
		List<FilterBooleanValue> booleanFilterValue = filter.getFilterBooleanValue();
		for(var booleanFilter :booleanFilterValue) {
			criteriaBuilder.or(criteriaBuilder.equal( root.get(filter.getFieldName()), booleanFilter.getId()));
		}
		return predicate;
	}
}
