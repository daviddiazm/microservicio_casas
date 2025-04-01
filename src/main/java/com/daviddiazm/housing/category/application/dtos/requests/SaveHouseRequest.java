package com.daviddiazm.housing.category.application.dtos.requests;

import com.daviddiazm.housing.category.domain.enums.PublishState;

import java.time.LocalDate;

public record SaveHouseRequest(
        Long id,
        String name,
        String description,
        int roomsQuantity,
        int bathroomsQuantity,
        String address,
        double price,
        LocalDate createDate,
        LocalDate publishDate,
        Long categoryModel_id,
        Long locationModel_id,
        PublishState publishState
) {
}
