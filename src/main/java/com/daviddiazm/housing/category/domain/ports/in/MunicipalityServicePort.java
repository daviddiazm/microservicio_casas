package com.daviddiazm.housing.category.domain.ports.in;

import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;

public interface MunicipalityServicePort {
    void saveMunicipality (MunicipalityModel municipalityModel);
    PagedResult<MunicipalityModel> getPageMunicipalities (int page, int size, boolean orderAsc);
}
