package com.growthbeat.analytics.query.calculation;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class SumCalculationQuery extends CalculationQuery {

	private static final long serialVersionUID = 1L;

	private String property;

	public SumCalculationQuery() {
		super();
		setType(CalculationQueryType.sum);
	}

	public SumCalculationQuery(String property) {
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
