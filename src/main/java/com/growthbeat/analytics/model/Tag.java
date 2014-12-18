package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;
import com.growthbeat.http.JsonUtils;

public class Tag {

	private String id;
	private String applicationId;
	private String description;
	private Date created;

	public static Tag findById(String id, Context context) {
		String json = context.getGrowthbeatHttpClient().get("/1/tags/" + id, new HashMap<String, Object>());
		return JsonUtils.deserialize(json, Tag.class);
	}

	public static List<Tag> findByApplicationId(String applicationId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		String json = context.getGrowthbeatHttpClient().get("/1/tags/", params);
		return JsonUtils.deserialize(json, new TypeReference<List<Tag>>() {
		});
	}

	public static Tag create(String parentTagId, String applicationId, String name, String description, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		params.put("parentTagId", parentTagId);
		params.put("name", name);
		params.put("description", description);
		String json = context.getGrowthbeatHttpClient().post("/1/tags", params);
		return JsonUtils.deserialize(json, Tag.class);
	}

	public static Tag update(String tagId, String description, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("description", description);
		String json = context.getGrowthbeatHttpClient().put("/1/tags/" + tagId, params);
		return JsonUtils.deserialize(json, Tag.class);
	}

	public static void delete(String tagId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		context.getGrowthbeatHttpClient().delete("/1/tags/" + tagId, params);
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
