package com.daviddiazm.housing.category.application.dtos.requests;

public record GetFilterHouseByCityNameRequest(
        int page,
        int size,
        boolean orderAsc,
        String cityName,
        Long idCategory,
        int roomsQuantity,
        int bathroomsQuantity,
        double minPrice,
        double maxPrice
) {
}
