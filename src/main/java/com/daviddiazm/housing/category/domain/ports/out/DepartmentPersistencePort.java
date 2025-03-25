package com.daviddiazm.housing.category.domain.ports.out;

import com.daviddiazm.housing.category.domain.models.DepartmentModel;

public interface DepartmentPersistencePort {
    void saveDepartment (DepartmentModel departmentModel );
    DepartmentModel getDepartmentByName (String departmentName );
    DepartmentModel getDepartmentById (Long id);
}
