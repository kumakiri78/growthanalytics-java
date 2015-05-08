package com.growthbeat.analytics.query.metric;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.growthbeat.analytics.query.segment.SegmentQuery;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class SegmentMetricQuery extends MetricQuery {

	private static final long serialVersionUID = 1L;

	private SegmentQuery segmentQuery;

	public SegmentMetricQuery() {
		super(MetricQueryType.segment);
	}

	public SegmentMetricQuery(SegmentQuery segmentQuery) {
		this();
		setSegmentQuery(segmentQuery);
	}

	public SegmentMetricQuery(SegmentQuery segmentQuery, MetricQueryDirection direction) {
		this(segmentQuery);
		setDirection(direction);
	}

	public SegmentQuery getSegmentQuery() {
		return segmentQuery;
	}

	public void setSegmentQuery(SegmentQuery segmentQuery) {
		this.segmentQuery = segmentQuery;
	}

}