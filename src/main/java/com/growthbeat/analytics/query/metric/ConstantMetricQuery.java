package com.growthbeat.analytics.query.metric;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class ConstantMetricQuery extends MetricQuery {

	private double value;

	public ConstantMetricQuery() {
		super(MetricQueryType.constant);
	}

	public ConstantMetricQuery(double value) {
		this();
		setValue(value);
	}

	public ConstantMetricQuery(double value, MetricQueryDirection direction) {
		this(value);
		setDirection(direction);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
