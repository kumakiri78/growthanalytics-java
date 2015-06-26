package com.growthbeat.analytics.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.growthbeat.Context;
import com.growthbeat.model.Model;
import com.growthbeat.utils.JsonUtils;

public class ClientTagRequest extends Model {

	private String clientId;
	private String tagId;
	private String value;

	public static AsyncApiJob bulkCreate(String applicationId, List<ClientTagRequest> clientTagRequests, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		params.put("clientTagRequests", JsonUtils.serialize(clientTagRequests));
		return post(context, "/1/client_tags/bulk", params, AsyncApiJob.class);
	}
	
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
