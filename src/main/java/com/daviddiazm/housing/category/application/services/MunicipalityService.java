package com.daviddiazm.housing.category.application.services;

import com.daviddiazm.housing.category.application.dtos.requests.GetMunicipalitiesPagedRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveMunicipalityRequest;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveMunicipalityResponse;
import com.daviddiazm.housing.category.domain.models.MunicipalityModel;

public interface MunicipalityService {
    SaveMunicipalityResponse saveMunicipality(SaveMunicipalityRequest saveMunicipalityRequest);

    PagedResultResponse<MunicipalityModel> getMunicipalitiesPaginated(GetMunicipalitiesPagedRequest request);
}
