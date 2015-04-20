package com.growthbeat.analytics.query.calculation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.growthbeat.analytics.query.BaseQuery;

@JsonDeserialize(using = JsonCalculationQueryDeserializer.class)
public abstract class CalculationQuery extends BaseQuery {

	private CalculationQueryType type;

	public CalculationQueryType getType() {
		return type;
	}

	public void setType(CalculationQueryType type) {
		this.type = type;
	}

}
