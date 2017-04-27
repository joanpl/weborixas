package com.jlo.weborixas.java;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.jlo.weborixas.java.models.Characteristic;

public class DBInitializer {
	
	private DynamoDBMapper mapper;
	private DynamoDB client;
	
	
	
	public void initialize() throws InterruptedException {
		CreateTableRequest tableRequest = mapper.generateCreateTableRequest(Characteristic.class); //1

		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L)); //2
//
		Table table = client.createTable(tableRequest);
		table.waitForActive();
	}

}






