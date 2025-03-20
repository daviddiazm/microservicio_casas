package com.daviddiazm.housing.category.domain.utils.factories;
import com.daviddiazm.housing.category.domain.models.DepartmentModel;
import com.daviddiazm.housing.category.domain.models.MunicipalityModel;

public class MunicipalityFactory {
    public static MunicipalityModel createMunicipality() {
        DepartmentModel cesar = DepartmentFactory.createDepartment();
        return new MunicipalityModel(1L, "valledupar", "es una ciudad de Colombia", cesar );
    }
    public static MunicipalityModel createMunicipality(Long id, String name, String description) {
        DepartmentModel cesar = DepartmentFactory.createDepartment();
        return new MunicipalityModel(id,name , description,  cesar );
    }
}