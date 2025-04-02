package com.daviddiazm.housing.category.application.services;

import com.daviddiazm.housing.category.application.dtos.requests.GetFilterHousePagedRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveHouseRequest;
import com.daviddiazm.housing.category.application.dtos.responses.HouseResponse;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveHouseResponse;
import com.daviddiazm.housing.category.domain.models.FilterHouseParameters;
import com.daviddiazm.housing.category.domain.models.PagedResult;

public interface HouseService {
    SaveHouseResponse saveHouse(SaveHouseRequest saveHouseRequest);
    PagedResultResponse<HouseResponse> filterHousePaged(GetFilterHousePagedRequest request);
}
