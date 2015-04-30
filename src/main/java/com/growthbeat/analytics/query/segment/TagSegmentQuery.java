package com.growthbeat.analytics.query.segment;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.growthbeat.analytics.query.Operator;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class TagSegmentQuery extends SegmentQuery {

	private static final long serialVersionUID = 1L;

	private String tagId;

	private Operator operator;

	private String value;

	public TagSegmentQuery() {
		super();
		setType(SegmentQueryType.tag);
	}

	public TagSegmentQuery(String tagId, Operator operator, String value) {
		this();
		setTagId(tagId);
		setOperator(operator);
		setValue(value);
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
