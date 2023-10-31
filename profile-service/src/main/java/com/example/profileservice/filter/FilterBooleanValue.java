package com.example.profileservice.filter;

import com.example.profileservice.enums.FilterTypeEnum;

/**
 * The Class FilterBooleanValue.
 */
public class FilterBooleanValue extends FilterType {

	/** The id. */
	private Integer id;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	@Override
	public String getType() {
		return FilterTypeEnum.BOOLEN_FILTER.getValue();
	}

}
