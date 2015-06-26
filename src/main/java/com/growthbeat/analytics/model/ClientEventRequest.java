package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.growthbeat.Context;
import com.growthbeat.model.Model;
import com.growthbeat.utils.JsonUtils;

public class ClientEventRequest extends Model {

	private String clientId;
	private String eventId;
	private Map<String, String> properties;
	private Date created;

	public static AsyncApiJob bulkCreate(String applicationId, List<ClientEventRequest> clientEventRequests, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		params.put("clientEventRequests", JsonUtils.serialize(clientEventRequests));
		return post(context, "/1/client_events/bulk", params, AsyncApiJob.class);
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
