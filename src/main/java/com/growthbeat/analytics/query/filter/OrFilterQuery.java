package com.growthbeat.analytics.query.filter;

import java.util.List;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class OrFilterQuery extends FilterQuery {

	private static final long serialVersionUID = 1L;

	private List<? extends FilterQuery> filterQueries;

	public OrFilterQuery() {
		super();
		setType(FilterQueryType.or);
	}

	public OrFilterQuery(List<? extends FilterQuery> filterQueries) {
		this();
		setFilterQueries(filterQueries);
	}

	public List<? extends FilterQuery> getFilterQueries() {
		return filterQueries;
	}

	public void setFilterQueries(List<? extends FilterQuery> filterQueries) {
		this.filterQueries = filterQueries;
	}

}
