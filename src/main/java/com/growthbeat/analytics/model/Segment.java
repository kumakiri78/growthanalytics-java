package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.growthbeat.Context;
import com.growthbeat.analytics.query.segment.SegmentQuery;
import com.growthbeat.constants.Constants;
import com.growthbeat.model.Model;
import com.growthbeat.model.Order;
import com.growthbeat.utils.DateUtils;
import com.growthbeat.utils.JsonUtils;

public class Segment extends Model {

	private String id;
	private String name;
	private String description;
	private int size;
	private SegmentQuery query;
	private Date created;

	public static Segment findById(String id, Context context) {
		return get(context, "/1/segments/" + id, new HashMap<String, Object>(), Segment.class);
	}

	public static List<Segment> findByParentSegmentId(String parentSegmentId, Order order, Integer page, Integer limit, Boolean onlyLeaf,
			Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentSegmentId", parentSegmentId);
		if (order != null)
			params.put("order", order.toString());
		if (page != null)
			params.put("page", page);
		if (limit != null)
			params.put("limit", limit);
		if (onlyLeaf != null)
			params.put("onlyLeaf", onlyLeaf);
		return get(context, "/1/segments", params, new TypeReference<List<Segment>>() {
		});
	}

	public static Set<String> findClientIdsBySegmentQuery(String applicationId, SegmentQuery segmentQuery,
			Date begin, Date end, boolean cacheable, Context context) {

		Map<String, Object> params = new HashMap<String, Object>();
		if (applicationId != null)
			params.put("applicationId", applicationId);
		if (segmentQuery != null)
			params.put("segmentQuery", JsonUtils.serialize(segmentQuery));
		if (begin != null)
			params.put("begin", DateUtils.dateTimeStringFromDateWithFormat(begin, Constants.ISO_8601_DATETIME_FORMAT));
		if (end != null)
			params.put("end", DateUtils.dateTimeStringFromDateWithFormat(end, Constants.ISO_8601_DATETIME_FORMAT));
		params.put("cacheable", cacheable);

		return get(context, "/1/segments/client_ids", params, new TypeReference<Set<String>>() {
		});
	}

	public static Segment update(String id, String name, String description, SegmentQuery query, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("description", description);
		if (query != null)
			params.put("query", JsonUtils.serialize(query));
		return put(context, "/1/segments/" + id, params, Segment.class);
	}

	public static Segment updateSize(String id, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		return put(context, "/1/segments/" + id + "/size", params, Segment.class);
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public SegmentQuery getQuery() {
		return query;
	}

	public void setQuery(SegmentQuery query) {
		this.query = query;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
