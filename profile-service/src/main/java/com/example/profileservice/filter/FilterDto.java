package com.example.profileservice.filter;

import java.util.List;
import java.util.Map;

public class FilterDto {
	private Integer offset;
	private Integer limit;
	private Map<String, CriteriaFilter> criteriaFilter;
	private SortItem sortItem;
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Map<String, CriteriaFilter> getCriteriaFilter() {
		return criteriaFilter;
	}
	public void setCriteriaFilter(Map<String, CriteriaFilter> criteriaFilter) {
		this.criteriaFilter = criteriaFilter;
	}
	public SortItem getSortItem() {
		return sortItem;
	}
	public void setSortItem(SortItem sortItem) {
		this.sortItem = sortItem;
	}
	
}
