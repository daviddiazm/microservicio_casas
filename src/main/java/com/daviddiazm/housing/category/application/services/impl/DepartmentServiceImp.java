package com.daviddiazm.housing.category.application.services.impl;

import com.daviddiazm.housing.category.application.dtos.requests.SaveDepartmentRequest;
import com.daviddiazm.housing.category.application.dtos.responses.SaveDepartmentResponse;
import com.daviddiazm.housing.category.application.mappers.DepartmentDtoMapper;
import com.daviddiazm.housing.category.application.services.DepartmentService;
import com.daviddiazm.housing.category.domain.ports.in.DepartmentServicePort;
import com.daviddiazm.housing.category.domain.utils.constants.DepartmentConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentServicePort departmentServicePort;
    private final DepartmentDtoMapper departmentDtoMapper;

    @Override
    public SaveDepartmentResponse saveDepartment(SaveDepartmentRequest saveDepartmentRequest) {
        departmentServicePort.saveDepartment(departmentDtoMapper.requestToModel(saveDepartmentRequest));
        return new SaveDepartmentResponse(DepartmentConstants.SAVE_CORRECTLY_MESSAGE, LocalDateTime.now());
    }
}
