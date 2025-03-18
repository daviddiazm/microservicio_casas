package com.daviddiazm.housing.category.application.services;

import com.daviddiazm.housing.category.application.dtos.requests.SaveMunicipalityRequest;
import com.daviddiazm.housing.category.application.dtos.responses.SaveMunicipalityResponse;

public interface MunicipalityService {
    SaveMunicipalityResponse saveMunicipality(SaveMunicipalityRequest saveMunicipalityRequest);
}
