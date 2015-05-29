package com.growthbeat.analytics.query.metric;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.growthbeat.analytics.query.calculation.CalculationQuery;
import com.growthbeat.analytics.query.filter.FilterQuery;
import com.growthbeat.analytics.query.time.TimeQuery;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class EventMetricQuery extends MetricQuery {

	private static final long serialVersionUID = 1L;

	private String eventId;

	private TimeQuery begin;

	private TimeQuery end;

	private CalculationQuery calculationQuery;

	private FilterQuery filterQuery;

	public EventMetricQuery() {
		super(MetricQueryType.event);
	}

	public EventMetricQuery(String eventId, TimeQuery begin, TimeQuery end, CalculationQuery calculationQuery) {
		this();
		setEventId(eventId);
		setBegin(begin);
		setEnd(end);
		setCalculationQuery(calculationQuery);
	}

	public EventMetricQuery(String eventId, TimeQuery begin, TimeQuery end, CalculationQuery calculationQuery, MetricQueryDirection direction, FilterQuery filterQuery) {
		this(eventId, begin, end, calculationQuery);
		setDirection(direction);
		setFilterQuery(filterQuery);
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public TimeQuery getBegin() {
		return begin;
	}

	public void setBegin(TimeQuery begin) {
		this.begin = begin;
	}

	public TimeQuery getEnd() {
		return end;
	}

	public void setEnd(TimeQuery end) {
		this.end = end;
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
