package com.growthbeat.analytics.model;

import java.util.HashMap;
import java.util.Map;

import com.growthbeat.Context;
import com.growthbeat.http.JsonUtils;

public class ClientSegment {

	private String clientId;
	private String segmentId;

	public static ClientSegment findByClientIdAndSegmentId(String clientId, String segmentId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clientId", clientId);
		params.put("segmentId", segmentId);
		String json = context.getGrowthbeatHttpClient().get("/1/client_segments", params);
		return JsonUtils.deserialize(json, ClientSegment.class);
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}

}
