package com.aovsa.bookingsApi.model.Business;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Getter
@Setter
@Document("businessTable")
public class BusinessModel {
    @Transient
    public static final String SEQUENCE_NAME = "business_sequence";

    @Id
    private String id;
    private String businessName;
    private BusinessType businessType;
    private String description;
    private String address;
}
