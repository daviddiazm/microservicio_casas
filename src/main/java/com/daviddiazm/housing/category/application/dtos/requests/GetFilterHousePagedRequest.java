package com.daviddiazm.housing.category.application.dtos.requests;

public record GetFilterHousePagedRequest(
        int page,
        int size,
        boolean orderAsc,
        Long idLocation,
        Long idCategory,
        int roomsQuantity,
        int bathroomsQuantity,
        double minPrice,
        double maxPrice
) {
}
