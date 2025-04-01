package com.daviddiazm.housing.category.application.services;

import com.daviddiazm.housing.category.application.dtos.requests.SaveHouseRequest;
import com.daviddiazm.housing.category.application.dtos.responses.SaveHouseResponse;

public interface HouseService {
    SaveHouseResponse saveHouse(SaveHouseRequest saveHouseRequest);
}
