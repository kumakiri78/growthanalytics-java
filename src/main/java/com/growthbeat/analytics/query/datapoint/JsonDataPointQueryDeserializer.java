package com.growthbeat.analytics.query.datapoint;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.growthbeat.http.JsonUtils;

public class JsonDataPointQueryDeserializer extends JsonDeserializer<DataPointQuery> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public DataPointQuery deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		ObjectCodec objectCodec = jp.getCodec();

		Map<String, Object> map = objectCodec.readValue(jp, new TypeReference<Map<String, Object>>() {
		});
		String json = JsonUtils.serialize(map);

		if (!map.containsKey("type") || map.get("type") == null)
			return null;

		DataPointQueryType type = null;
		try {
			type = DataPointQueryType.valueOf((String) map.get("type"));
		} catch (IllegalArgumentException e) {
			logger.warn("Invalid query type: " + e.getMessage());
			return null;
		}

		switch (type) {
		case metric:
			return JsonUtils.deserialize(json, MetricDataPointQuery.class);
		case constant:
			return JsonUtils.deserialize(json, ConstantDataPointQuery.class);
		case milestone:
			return JsonUtils.deserialize(json, MilestoneDataPointQuery.class);
		default:
			logger.warn("Invalid query type: null");
			return null;
		}

	}

}
