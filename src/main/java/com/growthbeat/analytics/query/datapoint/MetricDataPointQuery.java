package com.growthbeat.analytics.query.datapoint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.growthbeat.analytics.query.filter.FilterQuery;
import com.growthbeat.analytics.query.metric.MetricQuery;
import com.growthbeat.analytics.query.time.TimeQuery;
import com.growthbeat.constants.Constants;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class MetricDataPointQuery extends DataPointQuery {

	private static final long serialVersionUID = 1L;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
	private TimeQuery begin;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
	private TimeQuery end;

	private long period;

	private MetricQuery metricQuery;

	private FilterQuery filterQuery;

	public MetricDataPointQuery() {
		super();
		setType(DataPointQueryType.metric);
	}

	public MetricDataPointQuery(String name, TimeQuery begin, TimeQuery end, long period, MetricQuery metricQuery) {
		this(begin, end, period, metricQuery);
		setName(name);
	}

	public MetricDataPointQuery(TimeQuery begin, TimeQuery end, long period, MetricQuery metricQuery) {
		this();
		setBegin(begin);
		setEnd(end);
		setPeriod(period);
		setMetricQuery(metricQuery);
	}

	public MetricDataPointQuery(TimeQuery begin, TimeQuery end, long period, MetricQuery metricQuery, FilterQuery filterQuery) {
		this(begin, end, period, metricQuery);
		setFilterQuery(filterQuery);
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

	public long getPeriod() {
		return period;
	}

	public void setPeriod(long period) {
		this.period = period;
	}

	public MetricQuery getMetricQuery() {
		return metricQuery;
	}

	public void setMetricQuery(MetricQuery metricQuery) {
		this.metricQuery = metricQuery;
	}

	public FilterQuery getFilterQuery() {
		return filterQuery;
	}

	public void setFilterQuery(FilterQuery filterQuery) {
		this.filterQuery = filterQuery;
	}

}
