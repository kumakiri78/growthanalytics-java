package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;
import com.growthbeat.model.Model;
import com.growthbeat.model.Order;

public class Segment extends Model {

	private String id;
	private String name;
	private String description;
	private String query;
	private Date created;

	public static Segment findById(String id, Context context) {
		return get(context, "/1/segments/" + id, new HashMap<String, Object>(), Segment.class);
	}

	public static List<Segment> findByParentSegmentId(String parentSegmentId, Order order, Integer page, Integer limit, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentSegmentId", parentSegmentId);
		if (order != null)
			params.put("order", order.toString());
		if (page != null)
			params.put("page", page);
		if (limit != null)
			params.put("limit", limit);
		return get(context, "/1/segments", params, new TypeReference<List<Segment>>() {
		});
	}

	public static Segment update(String id, String name, String description, String query, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("description", description);
		if (query != null)
			params.put("query", query);
		return put(context, "/1/segments/" + id, params, Segment.class);
	}

	public static void deleteById(String id, Context context) {
		delete(context, "/1/segments/" + id, new HashMap<String, Object>(), Void.class);
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
