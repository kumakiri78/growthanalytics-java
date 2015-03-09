package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;
import com.growthbeat.http.JsonUtils;
import com.growthbeat.model.Order;

public class Tag {

	private String id;
	private String name;
	private String description;
	private Date created;

	public static Tag findById(String id, Context context) {
		String json = context.getGrowthbeatHttpClient().get("/1/tags/" + id, new HashMap<String, Object>());
		return JsonUtils.deserialize(json, Tag.class);
	}

	public static List<Tag> findByParentTagId(String parentTagId, Order order, Integer page, Integer limit, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentTagId", parentTagId);
		if (order != null)
			params.put("order", order.toString());
		if (page != null)
			params.put("page", page);
		if (limit != null)
			params.put("limit", limit);
		String json = context.getGrowthbeatHttpClient().get("/1/tags", params);
		return JsonUtils.deserialize(json, new TypeReference<List<Tag>>() {
		});
	}

	public static Tag update(String id, String name, String description, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("description", description);
		String json = context.getGrowthbeatHttpClient().put("/1/tags/" + id, params);
		return JsonUtils.deserialize(json, Tag.class);
	}

	public static void deleteById(String id, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		context.getGrowthbeatHttpClient().delete("/1/tags/" + id, params);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
