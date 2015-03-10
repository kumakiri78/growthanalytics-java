package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;
import com.growthbeat.model.Model;
import com.growthbeat.model.Order;

public class Metric extends Model {

	private String id;
	private String name;
	private String description;
	private String query;
	private Integer color;
	private Date created;

	public static Metric findById(String id, Context context) {
		return get(context, "/1/metrics/" + id, new HashMap<String, Object>(), Metric.class);
	}

	public static List<Metric> findByParentMetricId(String parentMetricId, Order order, Integer page, Integer limit, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentMetricId", parentMetricId);
		if (order != null)
			params.put("order", order.toString());
		if (page != null)
			params.put("page", page);
		if (limit != null)
			params.put("limit", limit);
		return get(context, "/1/metrics", params, new TypeReference<List<Metric>>() {
		});
	}

	public static Metric update(String id, String name, String description, String query, Integer color, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("description", description);
		if (query != null)
			params.put("query", query);
		if (color != null)
			params.put("color", color);
		return put(context, "/1/metrics/" + id, params, Metric.class);
	}

	public static void deleteById(String id, Context context) {
		delete(context, "/1/metrics/" + id, new HashMap<String, Object>(), Void.class);
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

	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
