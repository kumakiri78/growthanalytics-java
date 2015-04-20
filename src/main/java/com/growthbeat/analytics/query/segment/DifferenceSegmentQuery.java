package com.growthbeat.analytics.query.segment;

import java.util.List;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class DifferenceSegmentQuery extends SegmentQuery {

	private List<? extends SegmentQuery> segmentQueries;

	public DifferenceSegmentQuery() {
		super();
		setType(SegmentQueryType.difference);
	}

	public DifferenceSegmentQuery(List<? extends SegmentQuery> segmentQueries) {
		this();
		this.setSegmentQueries(segmentQueries);
	}

	public List<? extends SegmentQuery> getSegmentQueries() {
		return segmentQueries;
	}

	public void setSegmentQueries(List<? extends SegmentQuery> segmentQueries) {
		this.segmentQueries = segmentQueries;
	}

}
