package com.growthbeat.analytics.query.segment;

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
import com.growthbeat.utils.JsonUtils;

public class JsonSegmentQueryDeserializer extends JsonDeserializer<SegmentQuery> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public SegmentQuery deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		ObjectCodec objectCodec = jp.getCodec();
		Map<String, Object> map = objectCodec.readValue(jp, new TypeReference<Map<String, Object>>() {
		});
		String json = JsonUtils.serialize(map);

		if (!map.containsKey("type") || map.get("type") == null)
			return null;

		SegmentQueryType type = null;
		try {
			type = SegmentQueryType.valueOf((String) map.get("type"));
		} catch (IllegalArgumentException e) {
			logger.warn("Invalid query type: " + e.getMessage());
			return null;
		}

		switch (type) {
		case client:
			return JsonUtils.deserialize(json, ClientSegmentQuery.class);
		case application:
			return JsonUtils.deserialize(json, ApplicationSegmentQuery.class);
		case event:
			return JsonUtils.deserialize(json, EventSegmentQuery.class);
		case tag:
			return JsonUtils.deserialize(json, TagSegmentQuery.class);
		case segment:
			return JsonUtils.deserialize(json, SegmentSegmentQuery.class);
		case and:
			return JsonUtils.deserialize(json, AndSegmentQuery.class);
		case or:
			return JsonUtils.deserialize(json, OrSegmentQuery.class);
		case difference:
			return JsonUtils.deserialize(json, DifferenceSegmentQuery.class);
		default:
			logger.warn("Invalid query type: null");
			return null;
		}

	}

}