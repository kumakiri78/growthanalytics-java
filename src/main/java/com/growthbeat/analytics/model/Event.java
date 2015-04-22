package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.growthbeat.Context;
import com.growthbeat.model.Model;
import com.growthbeat.model.Order;

public class Event extends Model {

	private String id;
	private String name;
	private String description;
	private Date created;

	public static Event findById(String id, Context context) {
		return get(context, "/1/events/" + id, new HashMap<String, Object>(), Event.class);
	}

	public static List<Event> findByParentEventId(String parentEventId, Order order, Integer page, Integer limit, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentEventId", parentEventId);
		if (order != null)
			params.put("order", order.toString());
		if (page != null)
			params.put("page", page);
		if (limit != null)
			params.put("limit", limit);
		return get(context, "/1/events", params, new TypeReference<List<Event>>() {
		});
	}

	public static Event update(String id, String name, String description, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("description", description);
		return put(context, "/1/events/" + id, params, Event.class);
	}

	public static void deleteById(String id, Context context) {
		delete(context, "/1/events/" + id, new HashMap<String, Object>(), Void.class);
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
