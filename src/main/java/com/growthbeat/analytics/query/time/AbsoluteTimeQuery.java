package com.growthbeat.analytics.query.time;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.growthbeat.constants.Constants;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class AbsoluteTimeQuery extends TimeQuery {

	private static final long serialVersionUID = 1L;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
	private Date time;

	public AbsoluteTimeQuery() {
		super();
		setType(TimeQueryType.absolute);
	}

	public AbsoluteTimeQuery(Date time) {
		this();
		setTime(time);
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
