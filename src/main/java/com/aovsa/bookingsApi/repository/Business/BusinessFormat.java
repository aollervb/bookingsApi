package com.aovsa.bookingsApi.repository.Business;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.aovsa.bookingsApi.model.Business.BusinessModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@DynamoDBTypeConverted(converter=BusinessFormat.Converter.class)
public @interface BusinessFormat {
    String separator() default " ";

    public static class Converter implements DynamoDBTypeConverter<String,BusinessModel> {
        private final String separator;
        public Converter(final Class<BusinessModel> targetType, final BusinessFormat annotation) {
            this.separator = annotation.separator();
        }
        public Converter() {
            this.separator = "|";
        }

        @Override
        public String convert(BusinessModel businessModel) {
            return null;
        }

        @Override
        public BusinessModel unconvert(String s) {
            return null;
        }

    }
}
