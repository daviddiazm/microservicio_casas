package com.daviddiazm.housing.category.domain.ports.in;

import com.daviddiazm.housing.category.domain.models.DepartmentModel;

public interface DepartmentServicePort {
    void saveDepartment (DepartmentModel departmentModel);

}
