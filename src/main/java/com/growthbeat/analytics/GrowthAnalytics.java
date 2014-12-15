package com.growthbeat.analytics;

import java.util.List;

import com.growthbeat.Context;
import com.growthbeat.analytics.model.Event;
import com.growthbeat.analytics.model.Tag;

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

	public Event findEventById(String id) {
		return Event.findById(id, context);
	}

	public List<Event> findEventByApplicationId(String applicationId) {
		return Event.findByApplicationId(applicationId, context);
	}

	public Event createEvent(String parentEventId, String applicationId, String name, String description) {
		return Event.create(parentEventId, applicationId, name, description, context);
	}

	public Event updateEvent(String eventId, String description) {
		return Event.update(eventId, description, context);
	}

	public void deleteEvent(String eventId) {
		Event.delete(eventId, context);
	}

	public Tag findTagById(String id) {
		return Tag.findById(id, context);
	}

	public List<Tag> findTagByApplicationId(String applicationId) {
		return Tag.findByApplicationId(applicationId, context);
	}

	public Tag createTag(String parentTagId, String applicationId, String name, String description) {
		return Tag.create(parentTagId, applicationId, name, description, context);
	}

	public Tag updateTag(String tagId, String description) {
		return Tag.update(tagId, description, context);
	}

	public void deleteTag(String tagId) {
		Tag.delete(tagId, context);
	}

}
