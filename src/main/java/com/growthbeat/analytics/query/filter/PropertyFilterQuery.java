package com.growthbeat.analytics.query.filter;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.growthbeat.analytics.query.Operator;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class PropertyFilterQuery extends FilterQuery {

	private String property;

	private Operator operator;

	private String value;

	public PropertyFilterQuery() {
		super();
		setType(FilterQueryType.property);
	}

	public PropertyFilterQuery(String property, Operator operator, String value) {
		this();
		setProperty(property);
		setOperator(operator);
		setValue(value);
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
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
