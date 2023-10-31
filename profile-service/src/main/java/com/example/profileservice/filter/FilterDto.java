package com.example.profileservice.filter;

import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class FilterDto.
 */
public class FilterDto {
	
	/** The offset. */
	private Integer offset;
	
	/** The limit. */
	private Integer limit;
	
	/** The criteria filter. */
	private Map<String, CriteriaFilter> criteriaFilter;
	
	/** The sort item. */
	private SortItem sortItem;
	
	/**
	 * Gets the offset.
	 *
	 * @return the offset
	 */
	public Integer getOffset() {
		return offset;
	}
	
	/**
	 * Sets the offset.
	 *
	 * @param offset the new offset
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
	/**
	 * Gets the limit.
	 *
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}
	
	/**
	 * Sets the limit.
	 *
	 * @param limit the new limit
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	/**
	 * Gets the criteria filter.
	 *
	 * @return the criteria filter
	 */
	public Map<String, CriteriaFilter> getCriteriaFilter() {
		return criteriaFilter;
	}
	
	/**
	 * Sets the criteria filter.
	 *
	 * @param criteriaFilter the criteria filter
	 */
	public void setCriteriaFilter(Map<String, CriteriaFilter> criteriaFilter) {
		this.criteriaFilter = criteriaFilter;
	}
	
	/**
	 * Gets the sort item.
	 *
	 * @return the sort item
	 */
	public SortItem getSortItem() {
		return sortItem;
	}
	
	/**
	 * Sets the sort item.
	 *
	 * @param sortItem the new sort item
	 */
	public void setSortItem(SortItem sortItem) {
		this.sortItem = sortItem;
	}
	
}
