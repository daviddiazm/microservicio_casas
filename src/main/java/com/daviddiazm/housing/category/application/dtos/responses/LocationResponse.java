package com.daviddiazm.housing.category.application.dtos.responses;

import com.daviddiazm.housing.category.domain.models.HouseModel;
import com.daviddiazm.housing.category.domain.models.MunicipalityModel;

import java.util.List;

public record LocationResponse(
        Long id,
        String sector,
        MunicipalityModel municipality,
        List<HouseModel>houses
) {
}
