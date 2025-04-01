package com.daviddiazm.housing.category.domain.utils.factories;

import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.domain.models.MunicipalityModel;

public class LocationFactory {
    public static LocationModel createLocation() {
        Long id = 1L;
        String sector = "Santa Lucia";
        MunicipalityModel municipality = MunicipalityFactory.createMunicipality();
        return new LocationModel(id, sector, municipality);
    }
}
