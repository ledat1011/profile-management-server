package com.example.profileservice.enums;

public enum FilterTypeEnum {
	
	TEXT_FILTER("filterTextValue"), 
	BOOLEN_FILTER("filterBooleanValue"), 
	DATE_FILTER("filterDateValue");

	private String value;

	FilterTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	/**
	 * From value.
	 *
	 * @param val the val
	 * @return the error codes enum
	 */
	public static FilterTypeEnum fromValue(String val) {
		for (FilterTypeEnum c : FilterTypeEnum.values()) {
			if (c.value.equals(val)) {
				return c;
			}
		}
		throw new IllegalArgumentException(val.toString());
	}

}
