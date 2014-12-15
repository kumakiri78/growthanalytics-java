package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;
import com.growthbeat.http.JsonUtils;

public class Event {

	private String id;
	private String applicationId;
	private String description;
	private Date created;

	public static Event findById(String id, Context context) {
		String json = context.getGrowthbeatHttpClient().get("/1/events/" + id, new HashMap<String, Object>());
		return JsonUtils.deserialize(json, Event.class);
	}

	public static List<Event> findByApplicationId(String applicationId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		String json = context.getGrowthbeatHttpClient().get("/1/events", params);
		return JsonUtils.deserialize(json, new TypeReference<List<Event>>() {
		});
	}

	public static Event create(String parentEventId, String applicationId, String name, String description, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		params.put("parentEventId", parentEventId);
		params.put("name", name);
		params.put("description", description);
		String json = context.getGrowthbeatHttpClient().post("/1/events", params);
		return JsonUtils.deserialize(json, Event.class);
	}

	public static Event update(String eventId, String description, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("description", description);
		String json = context.getGrowthbeatHttpClient().put("/1/events/" + eventId, params);
		return JsonUtils.deserialize(json, Event.class);
	}

	public static Event delete(String eventId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		String json = context.getGrowthbeatHttpClient().delete("/1/events/" + eventId, params);
		return JsonUtils.deserialize(json, Event.class);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
