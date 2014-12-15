package com.growthbeat.analytics;

import com.growthbeat.Context;

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

}
