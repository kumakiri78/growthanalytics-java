package com.growthbeat.analytics.model;

import java.util.Date;
import java.util.HashMap;

import com.growthbeat.Context;
import com.growthbeat.model.Model;

public class AsyncApiJob extends Model {

	private String jobId;
	private AsyncApiStatus status;
	private String error;
	private Date created;
	private Date updated;

	public static AsyncApiJob findById(String id, Context context) {
		return get(context, "/1/jobs/" + id, new HashMap<String, Object>(), AsyncApiJob.class);
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public AsyncApiStatus getStatus() {
		return status;
	}

	public void setStatus(AsyncApiStatus status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
