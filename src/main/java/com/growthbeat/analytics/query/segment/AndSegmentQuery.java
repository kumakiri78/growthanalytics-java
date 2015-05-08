package com.growthbeat.analytics.query.segment;

import java.util.List;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class AndSegmentQuery extends SegmentQuery {

	private static final long serialVersionUID = 1L;

	private List<? extends SegmentQuery> segmentQueries;

	public AndSegmentQuery() {
		super();
		setType(SegmentQueryType.and);
	}

	public AndSegmentQuery(List<? extends SegmentQuery> segmentQueries) {
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
