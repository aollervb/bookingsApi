package com.aovsa.bookingsApi.controller.Business;

import com.aovsa.bookingsApi.dto.Business.BusinessDTO;
import com.aovsa.bookingsApi.model.Business.BusinessModel;
import com.aovsa.bookingsApi.request.Business.CreateBusinessRequest;
import com.aovsa.bookingsApi.response.BaseResponse;
import com.aovsa.bookingsApi.service.Business.BusinessService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/business")
public class BusinessController {
    private final BusinessService businessService;
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    /**
     * Controller to get all businesses.
     *
     * @return List of all businesses
     */
    @GetMapping("/")
    public List<BusinessDTO> getAllBusiness() {

        return businessService.getBusiness()
                .stream()
                .map(businessService::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessModel> getBusinessById(@PathVariable String id) {

        return ResponseEntity
                .of(businessService.getBusinessById(id));
    }

    @PostMapping("/")
    public BaseResponse createBusiness(@RequestBody CreateBusinessRequest request) {
        return businessService.createBusiness(request);
    }

}
