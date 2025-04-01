package com.daviddiazm.housing.category.domain.utils.factories;
import com.daviddiazm.housing.category.domain.models.DepartmentModel;
import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.domain.models.MunicipalityModel;

import java.util.List;

public class MunicipalityFactory {
    public static MunicipalityModel createMunicipality() {
        DepartmentModel cesar = DepartmentFactory.createDepartment();
        List<LocationModel> locations = List.of();
        return new MunicipalityModel(1L, "valledupar", "es una ciudad de Colombia", cesar, locations );
    }
    public static MunicipalityModel createMunicipality(Long id, String name, String description) {
        DepartmentModel cesar = DepartmentFactory.createDepartment();
        List<LocationModel> locations = List.of();
        return new MunicipalityModel(id,name , description,  cesar, locations );
    }
}