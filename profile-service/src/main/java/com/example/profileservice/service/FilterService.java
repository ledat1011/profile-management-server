package com.example.profileservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dataservice.entity.CreditProfileEntity;
import com.example.profileservice.common.BaseService;
import com.example.profileservice.enums.SortTypeEnum;
import com.example.profileservice.filter.ConditionTypeTextFilterEnum;
import com.example.profileservice.filter.CriteriaFilter;
import com.example.profileservice.filter.FilterBooleanValue;
import com.example.profileservice.filter.FilterTextValue;
import com.example.profileservice.filter.SortItem;

@Service
public class FilterService extends BaseService {

	@SuppressWarnings("rawtypes")
	public PageImpl select(EntityManager entityManager,
			CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder,
			Order order, List<Predicate> predicates, Pageable pageable) {
		// Set the offset and limit for pagination
		criteriaQuery.where(
				criteriaBuilder.and(predicates.toArray(new Predicate[0])));
		criteriaQuery.orderBy(order);
		TypedQuery<?> query = entityManager.createQuery(criteriaQuery)
				.setFirstResult(
						(int) (pageable.getOffset() ))
				.setMaxResults(pageable.getPageSize());

		// Get total count for full pagination details
		long total = entityManager.createQuery(criteriaQuery).getResultList()
				.size();

		List<?> results = query.getResultList();

		return new PageImpl<>(results, pageable,
				total);

	}

	public Order buildOrder(CriteriaBuilder criteriaBuilder, Root<?> root,
			SortItem sortItem) {
		if (sortItem == null || sortItem.getFieldName() == null
				|| sortItem.getSortType() == null) {
			return criteriaBuilder.asc(root);
		}

		return SortTypeEnum.ASC.getValue().equals(sortItem.getSortType())
				? criteriaBuilder.asc(root.get(sortItem.getFieldName()))
				: criteriaBuilder.desc(root.get(sortItem.getFieldName()));
	}

	public List<Predicate> buildPredicate(CriteriaBuilder criteriaBuilder,
			Root<?> root, Map<String, CriteriaFilter> filter) {
		List<Predicate> predicates = new ArrayList<>();
		for (var entry : filter.entrySet()) {
			Predicate predicate = null;
			CriteriaFilter criteria = entry.getValue();
			if (criteria.getFilterTextValue() != null) {
				predicate = buildTextPredicate(criteria, criteriaBuilder, root);
			}
			if (criteria.getFilterBooleanValue() != null) {
				predicate = buildBooleanPredicate(criteria, criteriaBuilder,
						root);
			}
			if (predicate != null) {
				predicates.add(predicate);
			}

		}
		return predicates;
	}

	private Predicate buildTextPredicate(CriteriaFilter filter,
			CriteriaBuilder criteriaBuilder, Root<?> root) {
		Predicate predicate = criteriaBuilder.conjunction();
		FilterTextValue textFilter = filter.getFilterTextValue();
		ConditionTypeTextFilterEnum type = ConditionTypeTextFilterEnum
				.fromValue(textFilter.getConditionType().getConditionType());
		if (type == ConditionTypeTextFilterEnum.CONTAIN) {
			predicate = criteriaBuilder.like(root.get(filter.getFieldName()),
					"%" + textFilter.getValue() + "%");
		}
		if (type == ConditionTypeTextFilterEnum.DOES_NOT_CONTAIN) {
			predicate = criteriaBuilder.notLike(root.get(filter.getFieldName()),
					"%" + textFilter.getValue() + "%");
		}

		if (type == ConditionTypeTextFilterEnum.START_WITH) {
			predicate = criteriaBuilder.like(root.get(filter.getFieldName()),
					"%" + textFilter.getValue());
		}

		if (type == ConditionTypeTextFilterEnum.END_WITH) {
			predicate = criteriaBuilder.like(root.get(filter.getFieldName()),
					textFilter.getValue() + "%");
		}

		if (type == ConditionTypeTextFilterEnum.EXCACTLY) {
			predicate = criteriaBuilder.equal(root.get(filter.getFieldName()),
					textFilter.getValue());
		}

		return predicate;
	}

	private Predicate buildBooleanPredicate(CriteriaFilter filter,
			CriteriaBuilder criteriaBuilder, Root<?> root) {
		Predicate predicate = null;
		List<FilterBooleanValue> booleanFilterValue = filter
				.getFilterBooleanValue();
		for (var booleanFilter : booleanFilterValue) {
			criteriaBuilder.or(criteriaBuilder.equal(
					root.get(filter.getFieldName()), booleanFilter.getId()));
		}
		return predicate;
	}
}
