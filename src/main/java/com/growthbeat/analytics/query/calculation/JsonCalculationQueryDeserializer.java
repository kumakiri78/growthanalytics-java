package com.growthbeat.analytics.query.calculation;

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

public class JsonCalculationQueryDeserializer extends JsonDeserializer<CalculationQuery> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public CalculationQuery deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		ObjectCodec objectCodec = jp.getCodec();
		Map<String, Object> map = objectCodec.readValue(jp, new TypeReference<Map<String, Object>>() {
		});
		String json = JsonUtils.serialize(map);

		if (!map.containsKey("type") || map.get("type") == null)
			return null;

		CalculationQueryType type = null;
		try {
			type = CalculationQueryType.valueOf((String) map.get("type"));
		} catch (IllegalArgumentException e) {
			logger.warn("Invalid query type: " + e.getMessage());
			return null;
		}

		switch (type) {
		case count:
			return JsonUtils.deserialize(json, TotalCountCalculationQuery.class);
		case unique:
			return JsonUtils.deserialize(json, UniqueCountCalculationQuery.class);
		case sum:
			return JsonUtils.deserialize(json, SumCalculationQuery.class);
		case max:
			return JsonUtils.deserialize(json, MaxCalculationQuery.class);
		case min:
			return JsonUtils.deserialize(json, MinCalculationQuery.class);
		default:
			logger.warn("Invalid query type: null");
			return null;
		}

	}

}