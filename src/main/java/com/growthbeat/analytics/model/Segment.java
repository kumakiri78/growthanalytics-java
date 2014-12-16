package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;
import com.growthbeat.http.JsonUtils;

public class Segment {

	private String id;
	private String originId;
	private String originName;
	private String description;
	private String query;
	private Date created;

	public static Segment findById(String id, Context context) {
		String json = context.getGrowthbeatHttpClient().get("/1/segments/" + id, new HashMap<String, Object>());
		return JsonUtils.deserialize(json, Segment.class);
	}

	public static List<Segment> findByParentSegmentId(String parentSegmentId, Integer depth, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentSegmentId", parentSegmentId);
		if (depth != null)
			params.put("depth", depth);
		String json = context.getGrowthbeatHttpClient().get("/1/segments", params);
		return JsonUtils.deserialize(json, new TypeReference<List<Segment>>() {
		});
	}

	public static Segment create(String parentSegmentId, String name, String description, String query, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentSegmentId", parentSegmentId);
		params.put("name", name);
		params.put("description", description);
		params.put("query", query);
		String json = context.getGrowthbeatHttpClient().post("/1/segments", params);
		return JsonUtils.deserialize(json, Segment.class);
	}

	public static Segment update(String segmentId, String description, String query, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("description", description);
		params.put("query", query);
		String json = context.getGrowthbeatHttpClient().put("/1/segments/" + segmentId, params);
		return JsonUtils.deserialize(json, Segment.class);
	}

	public static void delete(String segmentId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		context.getGrowthbeatHttpClient().delete("/1/segments/" + segmentId, params);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOriginId() {
		return originId;
	}

	public void setOriginId(String originId) {
		this.originId = originId;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
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
