package com.example.profileservice.filter;

import java.util.List;
import java.util.Map;

/**
 * The Class CriteriaFilter.
 */
public class CriteriaFilter {
	
	/** The field name. */
	private String fieldName;
	
	/** The filter text value. */
	private FilterTextValue filterTextValue;
	
	/** The filter boolean value. */
	private List<FilterBooleanValue> filterBooleanValue;
	
	/**
	 * Gets the field name.
	 *
	 * @return the field name
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * Sets the field name.
	 *
	 * @param fieldName the new field name
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * Gets the filter text value.
	 *
	 * @return the filter text value
	 */
	public FilterTextValue getFilterTextValue() {
		return filterTextValue;
	}

	/**
	 * Sets the filter text value.
	 *
	 * @param filterTextValue the new filter text value
	 */
	public void setFilterTextValue(FilterTextValue filterTextValue) {
		this.filterTextValue = filterTextValue;
	}

	/**
	 * Gets the filter boolean value.
	 *
	 * @return the filter boolean value
	 */
	public List<FilterBooleanValue> getFilterBooleanValue() {
		return filterBooleanValue;
	}

	/**
	 * Sets the filter boolean value.
	 *
	 * @param filterBooleanValue the new filter boolean value
	 */
	public void setFilterBooleanValue(List<FilterBooleanValue> filterBooleanValue) {
		this.filterBooleanValue = filterBooleanValue;
	}

}
