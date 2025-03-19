package com.daviddiazm.housing.category.application.services;

import com.daviddiazm.housing.category.application.dtos.requests.SaveDepartmentRequest;
import com.daviddiazm.housing.category.application.dtos.responses.SaveDepartmentResponse;
import com.daviddiazm.housing.category.domain.models.DepartmentModel;

public interface DepartmentService {
    SaveDepartmentResponse saveDepartment(SaveDepartmentRequest saveDepartmentRequest);
}
