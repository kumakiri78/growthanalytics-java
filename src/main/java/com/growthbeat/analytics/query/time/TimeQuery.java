package com.growthbeat.analytics.query.time;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.growthbeat.analytics.query.BaseQuery;

@JsonDeserialize(using = JsonTimeQueryDeserializer.class)
public abstract class TimeQuery extends BaseQuery {

	private TimeQueryType type;

	public TimeQueryType getType() {
		return type;
	}

	public void setType(TimeQueryType type) {
		this.type = type;
	}

}
