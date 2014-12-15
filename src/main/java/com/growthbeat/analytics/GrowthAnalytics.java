package com.growthbeat.analytics;

import java.util.List;

import com.growthbeat.Context;
import com.growthbeat.analytics.model.Event;

public class GrowthAnalytics {

	private final String BASE_URL = "https://api.analytics.growthbeat.com";
	private Context context = new Context();

	public GrowthAnalytics() {
		super();
		context.getGrowthbeatHttpClient().setBaseUrl(BASE_URL);
	}

	public GrowthAnalytics(String credentialId) {
		this();
		context.setCredentialId(credentialId);
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public Event findById(String id) {
		return Event.findById(id, context);
	}

	public List<Event> findByApplicationId(String applicationId) {
		return Event.findByApplicationId(applicationId, context);
	}

	public Event create(String parentEventId, String applicationId, String name, String description) {
		return Event.create(parentEventId, applicationId, name, description, context);
	}

	public Event update(String eventId, String description) {
		return Event.update(eventId, description, context);
	}

	public void delete(String eventId) {
		Event.delete(eventId, context);
	}

}
