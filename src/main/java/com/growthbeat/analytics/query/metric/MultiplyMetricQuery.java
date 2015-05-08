package com.growthbeat.analytics.query.metric;

import java.util.List;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class MultiplyMetricQuery extends MetricQuery {

	private static final long serialVersionUID = 1L;

	private List<? extends MetricQuery> metricQueries;

	public MultiplyMetricQuery() {
		super(MetricQueryType.multiply);
	}

	public MultiplyMetricQuery(List<? extends MetricQuery> metricQueries) {
		this();
		setMetricQueries(metricQueries);
	}

	public MultiplyMetricQuery(List<? extends MetricQuery> metricQueries, MetricQueryDirection direction) {
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
