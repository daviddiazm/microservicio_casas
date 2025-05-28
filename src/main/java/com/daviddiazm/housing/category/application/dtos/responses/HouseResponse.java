package com.daviddiazm.housing.category.application.dtos.responses;

import com.daviddiazm.housing.category.domain.enums.PublishState;
import com.daviddiazm.housing.category.domain.models.CategoryModel;
import com.daviddiazm.housing.category.domain.models.LocationModel;

import java.time.LocalDate;

public record HouseResponse(
        Long id,
        String name,
        String description,
        int roomsQuantity,
        int bathroomsQuantity,
        String address,
        double price,
        LocalDate createDate,
        LocalDate publishDate,
        CategoryModel category,
        LocationModel location,
        PublishState publishState
) {
}
