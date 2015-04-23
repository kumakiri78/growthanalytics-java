package com.growthbeat.analytics.query.calculation;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class MinCalculationQuery extends CalculationQuery {

	private String property;

	public MinCalculationQuery() {
		super();
		setType(CalculationQueryType.min);
	}

	public MinCalculationQuery(String property) {
		this();
		setProperty(property);
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

}
