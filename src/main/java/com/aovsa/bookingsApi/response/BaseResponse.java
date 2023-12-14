package com.aovsa.bookingsApi.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class BaseResponse {
    private HttpStatus status;
}
