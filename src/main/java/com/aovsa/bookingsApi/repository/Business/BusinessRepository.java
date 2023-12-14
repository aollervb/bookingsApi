package com.aovsa.bookingsApi.repository.Business;

import com.aovsa.bookingsApi.model.Business.BusinessModel;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface BusinessRepository extends MongoRepository<BusinessModel, String> {
    @Override
    <S extends BusinessModel> List<S> findAll(Example<S> example);
    @Query("{ 'businessName' : ?0 }")
    BusinessModel findByBusinessName(String businessName);
    @Query("{ 'businessType' : ?0 }")
    List<BusinessModel> findByBusinessType(String businessType);
    @Override
    <S extends BusinessModel> List<S> insert(Iterable<S> entities);

    long count();
}