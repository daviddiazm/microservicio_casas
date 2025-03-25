package com.daviddiazm.housing.category.domain.ports.in;

import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;

public interface MunicipalityServicePort {
    void saveMunicipality (MunicipalityModel municipalityModel);
    PagedResult<MunicipalityModel> getMunicipalitiesPaginated (int page, int size, boolean orderAsc, String name);
}
