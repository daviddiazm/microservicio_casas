package com.daviddiazm.housing.category.application.services;

import com.daviddiazm.housing.category.application.dtos.requests.GetLocationsRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveLocationRequest;
import com.daviddiazm.housing.category.application.dtos.responses.SaveLocationResponse;
import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;

public interface LocationService {
    SaveLocationResponse saveLocation(SaveLocationRequest saveLocationRequest);
    PagedResult<LocationModel> getLocationsPaginated(GetLocationsRequest getLocationsRequest);
}
