package com.aovsa.bookingsApi.request;

import org.springframework.http.HttpStatusCode;

public class BaseRequest {
    private long createdOn;
    private long updatedOn;
    private HttpStatusCode statusCode;

}
