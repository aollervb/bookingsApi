package com.aovsa.bookingsApi.repository.Business;

import com.aovsa.bookingsApi.model.Business.BusinessModel;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableScan
public interface BusinessRepository extends CrudRepository<BusinessModel, String> {
    @Override
    Optional<BusinessModel> findById(String id);

}