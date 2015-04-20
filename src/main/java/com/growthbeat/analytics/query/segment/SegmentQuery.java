package com.growthbeat.analytics.query.segment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.growthbeat.analytics.query.BaseQuery;

@JsonDeserialize(using = JsonSegmentQueryDeserializer.class)
public abstract class SegmentQuery extends BaseQuery {

	protected SegmentQueryType type;

	public SegmentQueryType getType() {
		return type;
	}

	protected void setType(SegmentQueryType type) {
		this.type = type;
	}

	protected String note;

	public String getNote() {
		return note;
	}

	protected void setNote(String note) {
		this.note = note;
	}

}
