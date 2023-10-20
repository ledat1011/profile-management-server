package com.example.profileservice.filter;

public class FilterBooleanValue extends FilterType {
	private Integer id;
	
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String getType() {
		return FilterTypeEnum.BOOLEN_FILTER.getValue();
	}

}
