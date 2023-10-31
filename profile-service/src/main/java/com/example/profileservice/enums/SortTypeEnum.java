package com.example.profileservice.enums;

public enum SortTypeEnum {

	DESC("DESC"),
	ASC("ASC");
	/** The value. */
	private String value;
	
	SortTypeEnum(String value) {
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
	public static SortTypeEnum fromValue(String val) {
		for (SortTypeEnum c : SortTypeEnum.values()) {
			if (c.value.equals(val)) {
				return c;
			}
		}
		throw new IllegalArgumentException(val.toString());
	}


}
