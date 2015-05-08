package com.growthbeat.analytics.query.calculation;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class UniqueCalculationQuery extends CalculationQuery {

	private static final long serialVersionUID = 1L;

	public UniqueCalculationQuery() {
		super();
		setType(CalculationQueryType.unique);
	}

}
