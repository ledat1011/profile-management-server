package com.example.profileservice.filter;

import java.util.List;

public class CriteriaFilter {
	private String fieldName;
	private  FilterTextValue filterTextValue;
	private List<FilterBooleanValue> filterBooleanValue;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public FilterTextValue getFilterTextValue() {
		return filterTextValue;
	}
	public void setFilterTextValue(FilterTextValue filterTextValue) {
		this.filterTextValue = filterTextValue;
	}
	public List<FilterBooleanValue> getFilterBooleanValue() {
		return filterBooleanValue;
	}
	public void setFilterBooleanValue(List<FilterBooleanValue> filterBooleanValue) {
		this.filterBooleanValue = filterBooleanValue;
	}
	
	
}
