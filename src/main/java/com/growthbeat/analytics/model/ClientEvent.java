package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;
import com.growthbeat.http.JsonUtils;

public class ClientEvent {

	private String id;
	private String clientId;
	private String eventId;
	private Map<String, String> properties;
	private Date created;

	public static ClientEvent findById(String id, Context context) {
		String json = context.getGrowthbeatHttpClient().get("/1/client_events/" + id, new HashMap<String, Object>());
		return JsonUtils.deserialize(json, ClientEvent.class);
	}

	public static List<ClientEvent> findByClientId(String clientId, Date from, Date to, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clientId", clientId);
		params.put("from", from);
		params.put("to", to);
		String json = context.getGrowthbeatHttpClient().get("/1/client_events", params);
		return JsonUtils.deserialize(json, new TypeReference<List<ClientEvent>>() {
		});
	}

	public static List<ClientEvent> findByEventId(String eventId, Date from, Date to, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("eventId", eventId);
		params.put("from", from);
		params.put("to", to);
		String json = context.getGrowthbeatHttpClient().get("/1/client_events", params);
		return JsonUtils.deserialize(json, new TypeReference<List<ClientEvent>>() {
		});
	}

	public static ClientEvent create(String clientId, String eventId, Map<String, String> properties, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clientId", clientId);
		params.put("eventId", eventId);
		params.put("properties", properties.toString());
		String json = context.getGrowthbeatHttpClient().post("/1/client_events", params);
		return JsonUtils.deserialize(json, ClientEvent.class);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
