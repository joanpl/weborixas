package com.jlo.weborixas.java.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "characteristic")
public class Characteristic {
	
	private Orixa orixa;
	
	private String orixaName;
	
	@DynamoDBHashKey
	private String attribute;
	
	private String description;
	

	public Orixa getOrixa() {
		return orixa;
	}

	public void setOrixa(Orixa orixa) {
		this.orixa = orixa;
	}

	@DynamoDBAttribute
	public String getOrixaName() {
		return orixaName;
	}

	public void setOrixaName(String name) {
		this.orixaName = name;
	}

	@DynamoDBAttribute
	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String question) {
		this.attribute = question;
	}

	@DynamoDBAttribute
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
