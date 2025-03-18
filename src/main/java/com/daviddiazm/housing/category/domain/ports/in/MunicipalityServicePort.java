package com.daviddiazm.housing.category.domain.ports.in;

import com.daviddiazm.housing.category.domain.models.MunicipalityModel;

public interface MunicipalityServicePort {
    void saveMunicipality (MunicipalityModel municipalityModel);
}
