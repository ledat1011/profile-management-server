package com.example.profileservice.filter;

public class FilterTextValue extends FilterType{
	
	private ConditionType conditionType;
	
	public ConditionType getConditionType() {
		return conditionType;
	}

	public void setConditionType(ConditionType conditionType) {
		this.conditionType = conditionType;
	}

	@Override
	public String getType() {
		return FilterTypeEnum.TEXT_FILTER.getValue();
	}
	

}
