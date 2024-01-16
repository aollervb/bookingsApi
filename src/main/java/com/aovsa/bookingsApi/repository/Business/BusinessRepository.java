package com.aovsa.bookingsApi.repository.Business;

import com.aovsa.bookingsApi.model.Business.BusinessModel;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.List;

@Component
public class BusinessRepository {
    private final DynamoDbTemplate dynamoDbTemplate;
    private final DynamoDbClient dynamoDbClient;
    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;
    private DynamoDbTable<BusinessModel> dynamoDbTable;

    public BusinessRepository( DynamoDbTemplate dynamoDbTemplate,
                                 DynamoDbClient dynamoDbClient,
                                 DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.dynamoDbTemplate = dynamoDbTemplate;
        this.dynamoDbClient = dynamoDbClient;
        this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
    }

    public BusinessModel save(BusinessModel experimentModel) {
        return dynamoDbTemplate.save(experimentModel);
    }

    public BusinessModel update(BusinessModel experimentModel) {
        return dynamoDbTemplate.update(experimentModel);
    }

    public BusinessModel findById(String id) {
        Key key = Key.builder().partitionValue(id).build();
        return dynamoDbTemplate.load(key, BusinessModel.class);
    }

    public List<BusinessModel> findAll() {
        return dynamoDbTemplate.scanAll(BusinessModel.class).items().stream().toList();
    }

    public void createTable() {
        dynamoDbTable = dynamoDbEnhancedClient.table("business_model", TableSchema.fromBean(BusinessModel.class));
        dynamoDbTable.createTable();
    }

    public void deleteTable() {
        dynamoDbTable = dynamoDbEnhancedClient.table("business_model", TableSchema.fromBean(BusinessModel.class));
        dynamoDbTable.deleteTable();
    }

}