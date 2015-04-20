package com.growthbeat.analytics.query.time;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.growthbeat.http.JsonUtils;

public class JsonTimeQueryDeserializer extends JsonDeserializer<TimeQuery> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public TimeQuery deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		ObjectCodec objectCodec = jp.getCodec();

		Map<String, Object> map = null;
		try {
			map = objectCodec.readValue(jp, new TypeReference<Map<String, Object>>() {
			});
		} catch (JsonMappingException e) {
			String dateString = objectCodec.readValue(jp, String.class);
			Date time = DateUtils.dateFromString(Constants.ISO_8601_DATETIME_FORMAT, dateString);
			if (time == null)
				return null;
			return new AbsoluteTimeQuery(time);
		}

		String json = JsonUtils.serialize(map);

		if (!map.containsKey("type") || map.get("type") == null)
			return null;

		TimeQueryType type = null;
		try {
			type = TimeQueryType.valueOf((String) map.get("type"));
		} catch (IllegalArgumentException e) {
			logger.warn("Invalid query type: " + e.getMessage());
			return null;
		}

		switch (type) {
		case absolute:
			return JsonUtils.deserialize(json, AbsoluteTimeQuery.class);
		case relative:
			return JsonUtils.deserialize(json, RelativeTimeQuery.class);
		default:
			logger.warn("Invalid query type: null");
			return null;
		}

	}

}
