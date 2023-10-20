package com.example.profileservice.filter;

public enum ConditionTypeTextFilterEnum {

	CONTAIN(1),
	DOES_NOT_CONTAIN(2),
	START_WITH(3),
	END_WITH(4),
	EXCACTLY(5),
	IS_NOT(6);
	
	private Integer value;
	ConditionTypeTextFilterEnum(Integer value){
		this.value = value;
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	/**
	 * From value.
	 *
	 * @param val the val
	 * @return the error codes enum
	 */
	public static ConditionTypeTextFilterEnum fromValue(Integer val) {
		for (ConditionTypeTextFilterEnum c : ConditionTypeTextFilterEnum.values()) {
			if (c.value.equals(val)) {
				return c;
			}
		}
		throw new IllegalArgumentException(val.toString());
	}
}
