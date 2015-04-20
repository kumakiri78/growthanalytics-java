package com.growthbeat.analytics.query.segment;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class ApplicationSegmentQuery extends SegmentQuery {

	private String applicationId;

	public ApplicationSegmentQuery() {
		super();
		setType(SegmentQueryType.application);
	}

	public ApplicationSegmentQuery(String applicationId) {
		this();
		setApplicationId(applicationId);
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

}
