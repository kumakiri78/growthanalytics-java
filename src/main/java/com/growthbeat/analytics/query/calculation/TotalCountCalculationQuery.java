package com.growthbeat.analytics.query.calculation;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class TotalCountCalculationQuery extends CalculationQuery {

	public TotalCountCalculationQuery() {
		super();
		setType(CalculationQueryType.count);
	}

}
