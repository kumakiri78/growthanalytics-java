package com.growthbeat.analytics.model;

import java.util.HashMap;
import java.util.Map;

import com.growthbeat.Context;
import com.growthbeat.model.Model;

public class Application extends Model{

	public static com.growthbeat.model.Application initialize(String applicationId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		return post(context, "/1/initialize", params, com.growthbeat.model.Application.class);
	}
	
}
