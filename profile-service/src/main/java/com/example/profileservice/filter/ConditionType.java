package com.example.profileservice.filter;

public class ConditionType {
	
	/** The condition type. */
	private Integer conditionType;
	
	/** The option name. */
	private String optionName;

	/**
	 * Gets the condition type.
	 *
	 * @return the condition type
	 */
	public Integer getConditionType() {
		return conditionType;
	}

	/**
	 * Sets the condition type.
	 *
	 * @param conditionType the new condition type
	 */
	public void setConditionType(Integer conditionType) {
		this.conditionType = conditionType;
	}
	
	/**
	 * Gets the option name.
	 *
	 * @return the option name
	 */
	public String getOptionName() {
		return optionName;
	}

	/**
	 * Sets the option name.
	 *
	 * @param optionName the new option name
	 */
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

}
