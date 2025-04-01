package com.daviddiazm.housing.category.application.services;

import com.daviddiazm.housing.category.application.dtos.requests.SaveLocationRequest;
import com.daviddiazm.housing.category.application.dtos.responses.SaveLocationResponse;

public interface LocationService {
    SaveLocationResponse saveLocation(SaveLocationRequest saveLocationRequest);
}
