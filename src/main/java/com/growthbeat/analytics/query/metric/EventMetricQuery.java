package com.growthbeat.analytics.query.metric;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.growthbeat.analytics.query.calculation.CalculationQuery;
import com.growthbeat.analytics.query.filter.FilterQuery;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class EventMetricQuery extends MetricQuery {

	private static final long serialVersionUID = 1L;

	private String eventId;

	private CalculationQuery calculationQuery;

	private FilterQuery filterQuery;

	public EventMetricQuery() {
		super(MetricQueryType.event);
	}

	public EventMetricQuery(String eventId, CalculationQuery calculationQuery) {
		this();
		setEventId(eventId);
		setCalculationQuery(calculationQuery);
	}

	public EventMetricQuery(String eventId, CalculationQuery calculationQuery, MetricQueryDirection direction, FilterQuery filterQuery) {
		this(eventId, calculationQuery);
		setDirection(direction);
		setFilterQuery(filterQuery);
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public CalculationQuery getCalculationQuery() {
		return calculationQuery;
	}

	public void setCalculationQuery(CalculationQuery calculationQuery) {
		this.calculationQuery = calculationQuery;
	}

	public FilterQuery getFilterQuery() {
		return filterQuery;
	}

	public void setFilterQuery(FilterQuery filterQuery) {
		this.filterQuery = filterQuery;
	}

}
