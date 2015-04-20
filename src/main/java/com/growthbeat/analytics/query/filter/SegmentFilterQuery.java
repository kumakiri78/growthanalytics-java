package com.growthbeat.analytics.query.filter;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class SegmentFilterQuery extends FilterQuery {

	private SegmentQuery segmentQuery;

	public SegmentFilterQuery() {
		super();
		setType(FilterQueryType.segment);
	}

	public SegmentFilterQuery(SegmentQuery segmentQuery) {
		this();
		setSegmentQuery(segmentQuery);
	}

	public SegmentQuery getSegmentQuery() {
		return segmentQuery;
	}

	public void setSegmentQuery(SegmentQuery segmentQuery) {
		this.segmentQuery = segmentQuery;
	}

}
