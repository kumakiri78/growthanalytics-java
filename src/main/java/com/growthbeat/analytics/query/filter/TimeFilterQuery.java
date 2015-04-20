package com.growthbeat.analytics.query.filter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class TimeFilterQuery extends FilterQuery {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
	private TimeQuery begin;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
	private TimeQuery end;

	public TimeFilterQuery() {
		super();
		setType(FilterQueryType.time);
	}

	public TimeFilterQuery(TimeQuery begin, TimeQuery end) {
		this();
		setBegin(begin);
		setEnd(end);
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
}
