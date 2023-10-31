package com.example.profileservice.filter;

import com.example.profileservice.enums.FilterTypeEnum;

/**
 * The Class FilterTextValue.
 */
public class FilterTextValue extends FilterType {

	/** The condition type. */
	private ConditionType conditionType;

	/**
	 * Gets the condition type.
	 *
	 * @return the condition type
	 */
	public ConditionType getConditionType() {
		return conditionType;
	}

	/**
	 * Sets the condition type.
	 *
	 * @param conditionType the new condition type
	 */
	public void setConditionType(ConditionType conditionType) {
		this.conditionType = conditionType;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	@Override
	public String getType() {
		return FilterTypeEnum.TEXT_FILTER.getValue();
	}

}
