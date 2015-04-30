package com.growthbeat.analytics.query.filter;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.growthbeat.analytics.query.BaseQuery;

@JsonDeserialize(using = JsonFilterQueryDeserializer.class)
public abstract class FilterQuery extends BaseQuery {

	private static final long serialVersionUID = 1L;

	private FilterQueryType type;

	public FilterQueryType getType() {
		return type;
	}

	public void setType(FilterQueryType type) {
		this.type = type;
	}

}
