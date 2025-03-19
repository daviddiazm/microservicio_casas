package com.daviddiazm.housing.category.domain.utils.factories;

import com.daviddiazm.housing.category.domain.models.DepartmentModel;

public class DepartmentFactory {
    public static DepartmentModel createDepartment () {
        return new DepartmentModel(
                1L,
                "cesar",
                "una descripcion de prueba",
                null);
    }

    public static DepartmentModel createDepartment (Long id, String name, String description) {
        return new DepartmentModel( id, name, description, null);
    }

}
