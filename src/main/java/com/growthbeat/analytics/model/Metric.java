package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;
import com.growthbeat.http.JsonUtils;

public class Metric {

	private String id;
	private String description;
	private String query;
	private Date created;

	public static Metric findById(String id, Context context) {
		String json = context.getGrowthbeatHttpClient().get("/1/metrics/" + id, new HashMap<String, Object>());
		return JsonUtils.deserialize(json, Metric.class);
	}

	public static List<Metric> findByParentMetricId(String parentMetricId, Integer depth, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentMeticId", parentMetricId);
		if (depth != null)
			params.put("depth", depth);
		String json = context.getGrowthbeatHttpClient().get("/1/metrics", params);
		return JsonUtils.deserialize(json, new TypeReference<List<Metric>>() {
		});
	}

	public static Metric create(String parentMetricId, String name, String description, String query, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentMetricId", parentMetricId);
		params.put("name", name);
		params.put("description", description);
		params.put("query", query);
		String json = context.getGrowthbeatHttpClient().post("/1/metrics", params);
		return JsonUtils.deserialize(json, Metric.class);
	}

	public static Metric update(String metricId, String description, String query, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("description", description);
		params.put("query", query);
		String json = context.getGrowthbeatHttpClient().put("/1/metrics/" + metricId, params);
		return JsonUtils.deserialize(json, Metric.class);
	}

	public static Metric delete(String metricId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		String json = context.getGrowthbeatHttpClient().delete("/1/metrics/" + metricId, params);
		return JsonUtils.deserialize(json, Metric.class);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
