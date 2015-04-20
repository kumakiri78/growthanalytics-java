package com.growthbeat.analytics.query.calculation;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class UniqueCountCalculationQuery extends CalculationQuery {

	public UniqueCountCalculationQuery() {
		super();
		setType(CalculationQueryType.unique);
	}

}
