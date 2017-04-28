package com.jlo.weborixas.java;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.services.dynamodbv2.model.TableStatus;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.jlo.weborixas.java.models.Characteristic;
import com.jlo.weborixas.java.repositories.ICharacteristicRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = { "amazon.dynamodb.endpoint=http://localhost:8000/", "amazon.aws.accesskey=test1", "amazon.aws.secretkey=test231" })
public class CharacteristicsRepositoryTest {
 

    private DynamoDBMapper dynamoDBMapper;
 
    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
 
    @Autowired
    ICharacteristicRepository characteristicsRepository;
 
    private static final String ATTRIBUTE_NAME = "Vaidoso";
    private static final String ORIXA_NAME = "Oxum";
    
 
    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        CreateTableRequest tableRequest = dynamoDBMapper
   	          .generateCreateTableRequest(Characteristic.class);
   	        tableRequest.setProvisionedThroughput(
   	          new ProvisionedThroughput(1L, 1L));
      
       TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
            // This means the table doesn't exist in the account yet      
       
 
        dynamoDBMapper.batchDelete(
          (List<Characteristic>)characteristicsRepository.findAll());
    }
 
    @Test
    public void sampleTestCase() {
        Characteristic char1 = new Characteristic(ATTRIBUTE_NAME, ORIXA_NAME);
        characteristicsRepository.save(char1);
 
        List<Characteristic> result 
          = (List<Characteristic>) characteristicsRepository.findAll();
         
        assertTrue("Not empty", result.size() > 0);
        assertTrue("Contains item with expected orixa", 
          result.get(0).getOrixaName().equals(ORIXA_NAME));
    }
}