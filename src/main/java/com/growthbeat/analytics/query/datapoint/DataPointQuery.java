package com.growthbeat.analytics.query.datapoint;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.growthbeat.analytics.query.BaseQuery;

@JsonDeserialize(using = JsonDataPointQueryDeserializer.class)
public abstract class DataPointQuery extends BaseQuery {

	private DataPointQueryType type;

	private String name;

	public DataPointQueryType getType() {
		return type;
	}

	public void setType(DataPointQueryType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
