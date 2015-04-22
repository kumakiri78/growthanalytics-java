package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.growthbeat.Context;
import com.growthbeat.model.Model;
import com.growthbeat.model.Order;

public class Tag extends Model {

	private String id;
	private String name;
	private String description;
	private Date created;

	public static Tag findById(String id, Context context) {
		return get(context, "/1/tags/" + id, new HashMap<String, Object>(), Tag.class);
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
		return get(context, "/1/tags", params, new TypeReference<List<Tag>>() {
		});
	}

	public static Tag update(String id, String name, String description, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("description", description);
		return put(context, "/1/tags/" + id, params, Tag.class);
	}

	public static void deleteById(String id, Context context) {
		delete(context, "/1/tags/" + id, new HashMap<String, Object>(), Void.class);
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
