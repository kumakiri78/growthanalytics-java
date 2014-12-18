package com.growthbeat.analytics;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.growthbeat.Context;
import com.growthbeat.analytics.model.ClientEvent;
import com.growthbeat.analytics.model.ClientTag;
import com.growthbeat.analytics.model.Event;
import com.growthbeat.analytics.model.Metric;
import com.growthbeat.analytics.model.Segment;
import com.growthbeat.analytics.model.Tag;

public class GrowthAnalytics {

	private static final String BASE_URL = "https://api.analytics.growthbeat.com";
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

	public List<Event> findEventsByApplicationId(String applicationId) {
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

	public List<Tag> findTagsByApplicationId(String applicationId) {
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

	public Segment findById(String id) {
		return Segment.findById(id, context);
	}

	public List<Segment> findByParentSegmentId(String parentSegmentId, Integer depth) {
		return Segment.findByParentSegmentId(parentSegmentId, depth, context);
	}

	public Segment create(String parentSegmentId, String name, String description, String query) {
		return Segment.create(parentSegmentId, name, description, query, context);
	}

	public Segment update(String segmentId, String description, String query) {
		return Segment.update(segmentId, description, query, context);
	}

	public void delete(String segmentId) {
		Segment.delete(segmentId, context);
	}

	public Metric findMetricById(String id) {
		return Metric.findById(id, context);
	}

	public List<Metric> findMetricsByParentMetricId(String parentMetricId, Integer depth) {
		return Metric.findByParentMetricId(parentMetricId, depth, context);
	}

	public Metric createMetric(String parentMetricId, String name, String description, String query) {
		return Metric.create(parentMetricId, name, description, query, context);
	}

	public Metric updateMetric(String metricId, String description, String query) {
		return Metric.update(metricId, description, query, context);
	}

	public void deleteMetric(String metricId) {
		Metric.delete(metricId, context);
	}

	public ClientEvent findClientEventById(String id) {
		return ClientEvent.findById(id, context);
	}

	public List<ClientEvent> findClientEventsByClientId(String clientId, Date from, Date to) {
		return ClientEvent.findByClientId(clientId, from, to, context);
	}

	public List<ClientEvent> findClientEventsByEventId(String eventId, Date from, Date to) {
		return ClientEvent.findByEventId(eventId, from, to, context);
	}

	public ClientEvent createClientEvent(String clientId, String eventId, Map<String, String> properties) {
		return ClientEvent.create(clientId, eventId, properties, context);
	}

	public ClientTag findClientTagByClientIdAndTagId(String clientId, String tagId) {
		return ClientTag.findByClientIdAndTagId(clientId, tagId, context);
	}

	public List<ClientTag> findClientTagsByClientId(String clientId) {
		return ClientTag.findByClientId(clientId, context);
	}

	public List<ClientTag> findClientTagsByTagId(String tagId) {
		return ClientTag.findByTagId(tagId, context);
	}

	public ClientTag createClientTag(String clientId, String tagId, String value) {
		return ClientTag.create(clientId, tagId, value, context);
	}

}
