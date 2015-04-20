package com.growthbeat.analytics.query.datapoint;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class MilestoneDataPointQuery extends DataPointQuery {

	private String visionId;

	public MilestoneDataPointQuery() {
		super();
		setType(DataPointQueryType.milestone);
	}

	public MilestoneDataPointQuery(String visionId) {
		this();
		setVisionId(visionId);
	}

	public MilestoneDataPointQuery(String visionId, String name) {
		this(visionId);
		setName(name);
	}

	public String getVisionId() {
		return visionId;
	}

	public void setVisionId(String visionId) {
		this.visionId = visionId;
	}

}
