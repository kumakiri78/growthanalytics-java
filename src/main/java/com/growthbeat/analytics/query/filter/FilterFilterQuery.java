package com.growthbeat.analytics.query.filter;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class FilterFilterQuery extends FilterQuery {

	private String filterId;

	public FilterFilterQuery() {
		super();
		setType(FilterQueryType.filter);
	}

	public FilterFilterQuery(String filterId) {
		this();
		setFilterId(filterId);
	}

	public String getFilterId() {
		return filterId;
	}

	public void setFilterId(String filterId) {
		this.filterId = filterId;
	}

}
