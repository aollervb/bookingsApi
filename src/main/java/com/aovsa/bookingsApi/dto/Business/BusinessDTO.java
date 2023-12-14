package com.aovsa.bookingsApi.dto.Business;

import com.aovsa.bookingsApi.model.Business.BusinessModel;
import com.aovsa.bookingsApi.model.Business.BusinessType;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class BusinessDTO {
    private String id;
    private String businessName;
    private BusinessType businessType;
}
