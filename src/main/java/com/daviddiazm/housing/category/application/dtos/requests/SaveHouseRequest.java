package com.daviddiazm.housing.category.application.dtos.requests;

import com.daviddiazm.housing.category.domain.enums.PublishState;

import java.time.LocalDate;

public record SaveHouseRequest(
        String name,
        String description,
        int roomsQuantity,
        int bathroomsQuantity,
        String address,
        double price,
        LocalDate publishDate,
        Long categoryModel_id,
        Long locationModel_id
) {
}
