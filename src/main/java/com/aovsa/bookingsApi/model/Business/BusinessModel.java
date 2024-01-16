package com.aovsa.bookingsApi.model.Business;

import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

/**
 * Model class to represent a business. <br>
 * A business has the following attributes: <br>
 * <ul>
 *     <li>id: Unique identifier for each business</li>
 *     <li>businessName: Commercial name for the business</li>
 *     <li>businessType: BusinessType</li>
 *     <li>description: Business description</li>
 *     <li>address: Address to business location</li>
 * </ul>
 * @version 1.0
 * @since 12-12-2023
 */
@Setter
@DynamoDbBean
public class BusinessModel {
    private String id;
    private String businessName;
    private BusinessType businessType;
    private String description;
    private String address;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("id")
    public String getId() {
        return id;
    }
    @DynamoDbAttribute("businessName")
    public String getBusinessName() {
        return businessName;
    }
    @DynamoDbAttribute("businessType")
    public BusinessType getBusinessType() {return businessType;}
    @DynamoDbAttribute("description")
    public String getDescription() {
        return description;
    }
    @DynamoDbAttribute("address")
    public String getAddress() {
        return address;
    }
}
