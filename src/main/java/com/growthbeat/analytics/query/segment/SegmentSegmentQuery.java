package com.growthbeat.analytics.query.segment;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class SegmentSegmentQuery extends SegmentQuery {

	private String segmentId;

	public SegmentSegmentQuery() {
		super();
		setType(SegmentQueryType.segment);
	}

	public SegmentSegmentQuery(String segmentId) {
		this();
		setSegmentId(segmentId);
	}

	public String getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}

}
