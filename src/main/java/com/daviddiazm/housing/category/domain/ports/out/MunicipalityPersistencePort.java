package com.daviddiazm.housing.category.domain.ports.out;

import com.daviddiazm.housing.category.domain.models.MunicipalityModel;

public interface MunicipalityPersistencePort {
    void saveMunicipality(MunicipalityModel municipalityModel);
}
