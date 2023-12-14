package com.aovsa.bookingsApi.request.Business;

import com.aovsa.bookingsApi.model.Business.BusinessType;
import com.aovsa.bookingsApi.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateBusinessRequest extends BaseRequest {
    private String businessName;
    private BusinessType businessType;
    private String description;
    private String address;
}
