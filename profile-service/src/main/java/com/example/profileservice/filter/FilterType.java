package com.example.profileservice.filter;

public abstract class FilterType {
	protected String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public abstract String getType();
}
