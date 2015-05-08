package com.growthbeat.analytics.query.metric;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.growthbeat.analytics.query.BaseQuery;

@JsonDeserialize(using = JsonMetricQueryDeserializer.class)
public abstract class MetricQuery extends BaseQuery {

	private static final long serialVersionUID = 1L;

	protected MetricQueryType type;

	protected MetricQueryDirection direction = MetricQueryDirection.up;

	public MetricQuery() {
		super();
	}

	public MetricQuery(MetricQueryType type) {
		this();
		setType(type);
	}

	public MetricQuery(MetricQueryType type, MetricQueryDirection direction) {
		this(type);
		setDirection(direction);
	}

	public MetricQueryType getType() {
		return type;
	}

	protected void setType(MetricQueryType type) {
		this.type = type;
	}

	public MetricQueryDirection getDirection() {
		return direction;
	}

	public void setDirection(MetricQueryDirection direction) {
		this.direction = direction;
	}

}
