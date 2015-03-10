package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;
import com.growthbeat.model.Model;
import com.growthbeat.model.Order;

public class ClientEvent extends Model {

	private String id;
	private String clientId;
	private String eventId;
	private Map<String, String> properties;
	private Date created;

	public static List<ClientEvent> findByClientIdAndEventId(String clientId, String eventId, Date begin, Date end, String exclusiveId,
			Order order, Integer limit, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clientId", clientId);
		params.put("eventId", eventId);
		params.put("begin", begin);
		params.put("end", end);
		if (exclusiveId != null)
			params.put("exclusiveId", exclusiveId);
		if (order != null)
			params.put("order", order);
		if (limit != null)
			params.put("limit", limit);
		return get(context, "/1/client_events", params, new TypeReference<List<ClientEvent>>() {
		});
	}

	public static ClientEvent create(String clientId, String eventId, Map<String, String> properties, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clientId", clientId);
		params.put("eventId", eventId);
		if (properties != null) {
			for (Map.Entry<String, String> entry : properties.entrySet()) {
				params.put(String.format("properties[%s]", entry.getKey()), entry.getValue());
			}
		}
		return post(context, "/1/client_events", params, ClientEvent.class);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
