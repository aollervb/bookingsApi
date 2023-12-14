package com.aovsa.bookingsApi.model.Business;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

/**
 * Enum class to represent the type of business. <br>
 * Currently the types are: <br>
 * <ul>
 *     <li>Other</li>
 *     <li>Restaurant</li>
 *     <li>Salon</li>
 * </ul>
 * @version 1.0
 * @since 12-12-2023
 */
@Getter
public enum BusinessType {

    OTHER("Other"),
    RESTAURANT("Restaurant"),
    SALON("Salon");

    private final String businessType;
    BusinessType(String businessType) {
        this.businessType = businessType;
    }
    public String getBusinessType() {
        return this.businessType;
    }

    @JsonCreator
    public static BusinessType getDepartmentFromCode(String value) {
        for (BusinessType bt : BusinessType.values()) {
            if (bt.getBusinessType().equals(value)) {
                return bt;
            }
        }
        return null;
    }
}
