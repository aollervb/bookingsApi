package com.aovsa.bookingsApi.repository.Business;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.aovsa.bookingsApi.BookingsApiApplication;
import com.aovsa.bookingsApi.model.Business.BusinessModel;
import com.aovsa.bookingsApi.model.Business.BusinessType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest(classes = BookingsApiApplication.class)
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = {
        "amazon.dynamodb.endpoint=http://localhost:8000/",
        "amazon.aws.accesskey=test1",
        "amazon.aws.secretkey=test231" })
public class BusinessRepositoryIntegrationTest {

    private static DynamoDBMapper dynamoDBMapper;

    @Autowired
    private static AmazonDynamoDB amazonDynamoDB;

    @Autowired
    private static BusinessRepository repository;

    private static final String EXPECTED_COST = "20";
    private static final String EXPECTED_PRICE = "50";

    @BeforeAll
    public static void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        CreateTableRequest tableRequest = dynamoDBMapper
                .generateCreateTableRequest(BusinessModel.class);
        tableRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest);

        //...

        dynamoDBMapper.batchDelete(
                (List<BusinessModel>)repository.findAll());
    }

    @Test
    public void givenItemWithExpectedCost_whenRunFindAll_thenItemIsFound() {
        BusinessModel business = new BusinessModel(
                "1", "Product Name", BusinessType.RESTAURANT, "Description", "Address"
        );
        repository.save(business);
        List<BusinessModel> result = (List<BusinessModel>) repository.findAll();

        assertTrue("There has to be at least one element in the database.",
                !result.isEmpty());
        assertEquals("The business name is equal to the one given to the BusinessModel created.",
                result.get(0).getBusinessName(),business.getBusinessName());
    }
}

