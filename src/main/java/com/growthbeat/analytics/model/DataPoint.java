package com.growthbeat.analytics.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;
import com.growthbeat.model.Model;

public class DataPoint extends Model {

	private String category;
	private String value;

	public static List<DataPoint> findByDataPointQuery(String dataPointQuery, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dataPointQuery", dataPointQuery);
		return get(context, "/1/data_points", params, new TypeReference<List<DataPoint>>() {
		});
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
