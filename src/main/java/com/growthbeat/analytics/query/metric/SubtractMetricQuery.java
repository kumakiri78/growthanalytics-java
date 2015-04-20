package com.growthbeat.analytics.query.metric;

import java.util.List;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class SubtractMetricQuery extends MetricQuery {

	private List<? extends MetricQuery> metricQueries;

	public SubtractMetricQuery() {
		super(MetricQueryType.subtract);
	}

	public SubtractMetricQuery(List<? extends MetricQuery> metricQueries) {
		this();
		setMetricQueries(metricQueries);
	}

	public SubtractMetricQuery(List<? extends MetricQuery> metricQueries, MetricQueryDirection direction) {
		this(metricQueries);
		setDirection(direction);
	}

	public List<? extends MetricQuery> getMetricQueries() {
		return metricQueries;
	}

	public void setMetricQueries(List<? extends MetricQuery> metricQueries) {
		this.metricQueries = metricQueries;
	}

}
