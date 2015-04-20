package com.growthbeat.analytics.query.filter;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class NotFilterQuery extends FilterQuery {

	private FilterQuery filterQuery;

	public NotFilterQuery() {
		super();
		setType(FilterQueryType.not);
	}

	public NotFilterQuery(FilterQuery filterQuery) {
		this();
		setFilterQuery(filterQuery);
	}

	public FilterQuery getFilterQuery() {
		return filterQuery;
	}

	public void setFilterQuery(FilterQuery filterQuery) {
		this.filterQuery = filterQuery;
	}

}
