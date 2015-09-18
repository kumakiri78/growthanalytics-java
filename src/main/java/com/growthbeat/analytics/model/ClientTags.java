package com.growthbeat.analytics.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.growthbeat.Context;
import com.growthbeat.model.Model;
import com.growthbeat.utils.JsonUtils.HTMLCharacterEscapes;

public class ClientTags extends Model {

	private static Logger logger = LoggerFactory.getLogger(ClientTags.class);

	private String[] clientIds = {};
	private String tagId;
	private String value;
	private Date updated;

	public static ClientTags create(String[] clientIds, String tagId, String value, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
			ObjectMapper mapper = new ObjectMapper();
			mapper.getJsonFactory().setCharacterEscapes(new HTMLCharacterEscapes());

			String json = null;
			try {
				json = mapper.writeValueAsString(new ClientTags(clientIds, tagId, value));
			} catch (IOException e) {
				logger.debug("Serialization error. " + e.getMessage());
			}

			Output output = new Output(byteArrayOutputStream);
			new Kryo().writeObject(output, json);
			params.put("clientTags", new String(byteArrayOutputStream.toByteArray(), "UTF-8"));

		} catch (IOException e) {
			logger.error("Can not create ClientTags. ", e);
			return null;
		}
		System.out.println("<< URI >>:" + context.getGrowthbeatHttpClient().getBaseUrl()+"/1/client_tags/bulk_insert");
		return post(context, "/1/client_tags/bulk_insert", params, ClientTags.class);
	}

	public ClientTags() {
		super();
	}

	public ClientTags(String[] clientIds, String tagId, String value) {
		this();
		setClientIds(clientIds);
		setTagId(tagId);
		setValue(value);
	}

	public String[] getClientIds() {
		return clientIds;
	}

	public void setClientIds(String[] clientIds) {
		this.clientIds = clientIds;
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

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
