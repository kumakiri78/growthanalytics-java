package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.Map;

import com.growthbeat.model.Model;

public class ClientEventRequest extends Model {

	private String clientId;
	private String eventId;
	private Map<String, String> properties;
	private Date created;

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
