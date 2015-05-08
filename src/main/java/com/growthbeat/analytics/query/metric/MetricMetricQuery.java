package com.growthbeat.analytics.query.metric;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class MetricMetricQuery extends MetricQuery {

	private static final long serialVersionUID = 1L;

	private String metricId;

	public MetricMetricQuery() {
		super(MetricQueryType.metric);
	}

	public MetricMetricQuery(String metricId) {
		this();
		setMetricId(metricId);
	}

	public MetricMetricQuery(String metricId, MetricQueryDirection direction) {
		this(metricId);
		setDirection(direction);
	}

	public String getMetricId() {
		return metricId;
	}

	public void setMetricId(String metricId) {
		this.metricId = metricId;
	}

}
