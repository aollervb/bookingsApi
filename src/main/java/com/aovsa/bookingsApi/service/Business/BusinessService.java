package com.aovsa.bookingsApi.service.Business;

import com.aovsa.bookingsApi.dto.Business.BusinessDTO;
import com.aovsa.bookingsApi.model.Business.BusinessModel;
import com.aovsa.bookingsApi.repository.Business.BusinessRepository;
import com.aovsa.bookingsApi.request.Business.CreateBusinessRequest;
import com.aovsa.bookingsApi.response.BaseResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {
    private final BusinessRepository businessRepository;
    private final ModelMapper mapper;
    public BusinessService (BusinessRepository businessRepository, ModelMapper mapper) {
        this.businessRepository = businessRepository;
        this.mapper = mapper;
    }

    public List<BusinessModel> getBusiness() {
        return businessRepository.findAll();
    }

    public Optional<BusinessModel> getBusinessById(String id) {
        return businessRepository.findById(id);
    }

    public BaseResponse createBusiness(CreateBusinessRequest request) {
        BusinessModel model = new BusinessModel();

        model.setBusinessName(request.getBusinessName());
        model.setBusinessType(request.getBusinessType());
        model.setDescription(request.getDescription());
        model.setAddress(request.getAddress());

        businessRepository.insert(model);

        BaseResponse response = new BaseResponse();
        response.setStatus(HttpStatus.CREATED);
        return response;
    }

    public BusinessDTO mapToDTO(BusinessModel businessModel) {
        return mapper.map(businessModel, BusinessDTO.class);
    }
}
