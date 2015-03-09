package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.growthbeat.Context;
import com.growthbeat.http.JsonUtils;

public class ClientTag {

	private String clientId;
	private String tagId;
	private String value;
	private Date updated;

	public static ClientTag create(String clientId, String tagId, String value, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clientId", clientId);
		params.put("tagId", tagId);
		if (value != null)
			params.put("value", value);
		String json = context.getGrowthbeatHttpClient().post("/1/client_tags", params);
		return JsonUtils.deserialize(json, ClientTag.class);
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
