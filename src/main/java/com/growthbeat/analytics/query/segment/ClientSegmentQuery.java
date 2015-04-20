package com.growthbeat.analytics.query.segment;

import java.util.List;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class ClientSegmentQuery extends SegmentQuery {

	private List<String> clientIds;

	public ClientSegmentQuery() {
		super();
		setType(SegmentQueryType.client);
	}

	public ClientSegmentQuery(List<String> clientIds) {
		this();
		setClientIds(clientIds);
	}

	public List<String> getClientIds() {
		return clientIds;
	}

	public void setClientIds(List<String> clientIds) {
		this.clientIds = clientIds;
	}

}
