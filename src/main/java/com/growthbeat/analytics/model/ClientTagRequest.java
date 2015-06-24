package com.growthbeat.analytics.model;

import com.growthbeat.model.Model;

public class ClientTagRequest extends Model {

	private String clientId;
	private String tagId;
	private String value;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
