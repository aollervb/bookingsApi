package com.aovsa.bookingsApi.controller.Business;

import com.aovsa.bookingsApi.dto.Business.BusinessDTO;
import com.aovsa.bookingsApi.model.Business.BusinessModel;
import com.aovsa.bookingsApi.repository.Business.BusinessRepository;
import com.aovsa.bookingsApi.request.Business.CreateBusinessRequest;
import com.aovsa.bookingsApi.response.BaseResponse;
import com.aovsa.bookingsApi.service.Business.BusinessService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/business")
public class BusinessController {
    private final BusinessService businessService;
    private final BusinessRepository businessRepository;
    public BusinessController(BusinessService businessService, BusinessRepository businessRepository) {
        this.businessService = businessService;
        this.businessRepository = businessRepository;
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
    public BusinessModel getBusinessById(@PathVariable String id) {
        return businessService.getBusinessById(id);
    }

    @PutMapping("")
    public void createTable() {
        businessRepository.createTable();
    }


    @PostMapping("/")
    public BaseResponse createBusiness(@RequestBody CreateBusinessRequest request) {
        return businessService.createBusiness(request);
    }

}
