package com.aovsa.bookingsApi.dto.Business;

import com.aovsa.bookingsApi.model.Business.BusinessType;
import lombok.Data;

@Data
public class BusinessSummaryDTO {
    private String id;
    private String businessName;
    private BusinessType businessType;
}
