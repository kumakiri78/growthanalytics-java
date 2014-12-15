package com.growthbeat.analytics.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;
import com.growthbeat.http.JsonUtils;

public class ClientTag {

	private String clientId;
	private String tagId;
	private String value;

	public static ClientTag findByClientIdAndTagId(String clientId, String tagId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clientId", clientId);
		params.put("tagId", tagId);
		String json = context.getGrowthbeatHttpClient().get("/1/client_tags/", params);
		return JsonUtils.deserialize(json, ClientTag.class);
	}

	public static List<ClientTag> findByClientId(String clientId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clientId", clientId);
		String json = context.getGrowthbeatHttpClient().get("/1/client_tags", params);
		return JsonUtils.deserialize(json, new TypeReference<List<ClientTag>>() {
		});
	}

	public static List<ClientTag> findByTagId(String tagId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tagId", tagId);
		String json = context.getGrowthbeatHttpClient().get("/1/client_tags", params);
		return JsonUtils.deserialize(json, new TypeReference<List<ClientTag>>() {
		});
	}

	public static ClientTag create(String clientId, String tagId, String value, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clientId", clientId);
		params.put("tagId", tagId);
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

}
