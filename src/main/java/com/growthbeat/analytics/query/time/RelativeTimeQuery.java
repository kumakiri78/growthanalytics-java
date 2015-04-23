package com.growthbeat.analytics.query.time;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class RelativeTimeQuery extends TimeQuery {

	private Origin origin;

	private long time;

	public RelativeTimeQuery() {
		super();
		setType(TimeQueryType.relative);
	}

	public RelativeTimeQuery(Origin origin, long time) {
		this();
		setOrigin(origin);
		setTime(time);
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public enum Origin {
		now, begin, end
	}

}
