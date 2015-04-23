package com.growthbeat.analytics.query.segment;

import java.util.List;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class OrSegmentQuery extends SegmentQuery {

	private List<? extends SegmentQuery> segmentQueries;

	public OrSegmentQuery() {
		super();
		setType(SegmentQueryType.or);
	}

	public OrSegmentQuery(List<? extends SegmentQuery> segmentQueries) {
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
